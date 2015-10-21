package com.example.potato.cards.MC_Intelligence;

import android.util.Log;

import com.example.potato.cards.Card_Engine.*;
import com.example.potato.cards.Hearts.HControl;
import com.example.potato.cards.Hearts.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Created by Potato on 8/12/2015.
 */
public class MCBrain {

    private String suiteToPlay;
    private boolean heartsBroken;

    ArrayList<MCPlayer> allMCPlayers;
    MCPlayerIngelligent intelligentMe;
    ArrayList<MCPlayerRandom> randomPlayersList;

    LinkedHashMap<SimpleCard, MCPlayer> onTableMC;

    int turnNumber;
    int nextPlayerTurn;

    SimpleCard firstCard;

    ArrayList<Integer> orderRemaining;

    boolean firstTurn;


    public MCBrain(MCPlayerIngelligent me, ArrayList<MCPlayerRandom> randomPlayers, String suiteToPlay, boolean heartsBroken, int turnNum, LinkedHashMap<Card, Player> onTable, ArrayList<Integer> orderRemaining){
        this.intelligentMe = me;
        this.randomPlayersList = randomPlayers;

        this.suiteToPlay = suiteToPlay;
        this.heartsBroken = heartsBroken;
        this.turnNumber = turnNum;

        this.orderRemaining = orderRemaining;

        this.allMCPlayers = new ArrayList<>();
        this.allMCPlayers.addAll(randomPlayersList);
        this.allMCPlayers.add(intelligentMe);


        this.onTableMC = new LinkedHashMap<>(onTable.size());

        Iterator<Card> it = onTable.keySet().iterator();
        while (it.hasNext()){
            Card nextCard = it.next();
            Object[] associatedVals = getAssociatedSimpleCardAndMCPlayer(nextCard, onTable.get(nextCard));
            this.onTableMC.put((SimpleCard) associatedVals[0], (MCPlayer) associatedVals[1]);
        }

        firstTurn = true;


    }

    // ALSO NEED TO REMOVE THE CARD FROM PLAYER'S HAND FOREVER, TREATING IT AS THE OTHER NEW RANDOM CARDS ARE PLAYED IN MCBrain -- different from HControl where cards are removed at once at the end of miniround
    private Object[] getAssociatedSimpleCardAndMCPlayer(Card c, Player p){
        SimpleCard cardToReturn = null;
        MCPlayer playerToReturn = null;


        for (MCPlayerRandom mcP: this.randomPlayersList){
            if (mcP.getPlayerNumber() == p.getPlayerNumber()) {
                playerToReturn = mcP;

                // if player matches, then search his cards for SimpleCard match
                for (SimpleCard card: mcP.cardsInHand){
                    if (c.equals(card)) {
                        cardToReturn = mcP.cardsInHand.remove(mcP.cardsInHand.indexOf(card));

                        switch (cardToReturn.getSuite()){
                            case "hearts":
                                mcP.heartsInHand.remove(mcP.heartsInHand.indexOf(card));
                                break;
                            case "spades":
                                mcP.spadesInHand.remove(mcP.spadesInHand.indexOf(card));
                                break;
                            case "diamonds":
                                mcP.diamondsInHand.remove(mcP.diamondsInHand.indexOf(card));
                                break;
                            case "clubs":
                                mcP.clubsInHand.remove(mcP.clubsInHand.indexOf(card));
                                break;

                        }
                        break; // if card is found and removed, just break the loop because otherwise ConcurrentModificationException
                    }
                }

            }
        }
        if (this.intelligentMe.getPlayerNumber() == p.getPlayerNumber()) {
            playerToReturn = this.intelligentMe;

            for (SimpleCard card: this.intelligentMe.cardsInHand){
                if (c.equals(card)) {
                    cardToReturn = intelligentMe.cardsInHand.remove(intelligentMe.cardsInHand.indexOf(card));

                    switch (cardToReturn.getSuite()){
                        case "hearts":
                            intelligentMe.heartsInHand.remove(intelligentMe.heartsInHand.indexOf(card));
                            break;
                        case "spades":
                            intelligentMe.spadesInHand.remove(intelligentMe.spadesInHand.indexOf(card));
                            break;
                        case "diamonds":
                            intelligentMe.diamondsInHand.remove(intelligentMe.spadesInHand.indexOf(card));
                            break;
                        case "clubs":
                            intelligentMe.clubsInHand.remove(intelligentMe.clubsInHand.indexOf(card));
                            break;

                    }
                }
            }
        }

        return new Object[]{cardToReturn, playerToReturn};


    }

    private boolean hasCard(MCPlayer player, String cardString){
        for (SimpleCard c: player.cardsInHand){
            if ((c.getStringValue()+"_"+c.getIntValue()).equalsIgnoreCase(cardString))
                return true;
        }
        return false;
    }


    private SimpleCard chooseRandomCard(ArrayList<SimpleCard> allCards){
        return allCards.get((new Random()).nextInt(allCards.size()));
    }


    private SimpleCard chooseRandomCard(MCPlayer player){

        if (suiteToPlay.equalsIgnoreCase("none")) {

            if (heartsBroken) {
                SimpleCard cardToPlay = player.playRandomCard();
                this.suiteToPlay = cardToPlay.getSuite();
                return cardToPlay;
            }
            else {
                SimpleCard cardToPlay = player.playRandomNonHeartsCard(2);
                this.suiteToPlay = cardToPlay.getSuite();
                return cardToPlay;
            }
        }
        else if (suiteToPlay.equalsIgnoreCase("hearts"))
            return player.playRandomHeart();
        else if (suiteToPlay.equalsIgnoreCase("diamonds"))
            return player.playRandomDiamond();
        else if (suiteToPlay.equalsIgnoreCase("clubs"))
            return player.playRandomClub(this.turnNumber);
        else if (suiteToPlay.equalsIgnoreCase("spades"))
            return player.playRandomSpade(2);
        else
            return null;

    }


    public Object[] playRoundMC(){
        if (!firstTurn){
            orderRemaining = HControl.getPlayerOrder(nextPlayerTurn);
        }

        if (this.onTableMC.size() == 0 && firstTurn) { // if this player must go first
            SimpleCard tempCard = chooseRandomCard(this.intelligentMe);
            this.onTableMC.put(tempCard, this.intelligentMe);
//                Log.d("card_playing", "Player #" + this.intelligentMe.getPlayerNumber() + " plays " + tempCard.toString());

            firstCard = tempCard;
            firstTurn = false;

//                this.orderRemaining = HControl.getPlayerOrder(this.intelligentMe.getPlayerNumber());
        }

        for (Integer i: this.orderRemaining){
            for (MCPlayer mcP: this.allMCPlayers){
                if (mcP.getPlayerNumber() == i.intValue()){
                    SimpleCard tempCard = chooseRandomCard(mcP);
                    this.onTableMC.put(tempCard, mcP); // plays random card and puts it on the table
//                        Log.d("card_playing", "Player #" + mcP.getPlayerNumber() + " plays " + tempCard.toString());

                    if (firstTurn && (mcP.getPlayerNumber() == intelligentMe.getPlayerNumber())) { // mcP.equals(intelligentMe) also should work? too lazy to test, my theory sucks :(
                        firstCard = tempCard;
                        firstTurn = false;
                    }
                }
            }
        }


        endMiniRoundMC(suiteToPlay);

        return null;
    }

    // check HControl::endMiniRound() for comments
    private void endMiniRoundMC(String originalSuite){

        int tempScore = 0;

        Iterator<SimpleCard> scoreCounterIter = this.onTableMC.keySet().iterator();

        while (scoreCounterIter.hasNext()){
            SimpleCard tempCard = scoreCounterIter.next();

            if (tempCard.getSuite().equalsIgnoreCase("hearts"))
                tempScore++;
            else if (tempCard.getStringValue().equalsIgnoreCase("queen") && tempCard.getSuite().equalsIgnoreCase("spades"))
                tempScore += 13;
        }

        Iterator<SimpleCard> tableSetIter = this.onTableMC.keySet().iterator();
        SimpleCard highestKey = tableSetIter.next();


        // determines who "takes" the hand
        while (tableSetIter.hasNext()){
            SimpleCard tempKey = tableSetIter.next();

            if (!(highestKey.getSuite().equalsIgnoreCase(originalSuite))){
                Log.d("ENDROUND2", "old highestcard == " + highestKey.toString() + " -- new highestcard == " + tempKey.toString());
                highestKey = tempKey;
                continue;
            }

            if (highestKey.getSuite().equalsIgnoreCase(originalSuite) && tempKey.getSuite().equalsIgnoreCase(originalSuite)){
                if (!(highestKey.getIntValue() > tempKey.getIntValue())) {
                    Log.d("ENDROUND3", "old highestcard == " + highestKey.toString() + " -- new highestcard == " + tempKey.toString());
                    highestKey = tempKey;
                }
            }
        }

        MCPlayer takesHand;

//        try{
        takesHand = this.onTableMC.get(highestKey);
        nextPlayerTurn = takesHand.getPlayerNumber();
        takesHand.addScore(tempScore);
//        } catch (NullPointerException e) {}

        Log.d("card_playing_end", "Player #" + takesHand.getPlayerNumber() + " takes the hand with score of " + tempScore);

        this.onTableMC.clear();




    }



    // These methods are used for simple iterative MC Simulations

    public Object[] playGame(){

//        if (this.turnNumber == 2)
//            System.out.println("test");

        while (intelligentMe.cardsInHand.size() != 0
                && randomPlayersList.get(0).cardsInHand.size() != 0
                && randomPlayersList.get(1).cardsInHand.size() != 0
                && randomPlayersList.get(2).cardsInHand.size() != 0){

            if (!firstTurn){
                orderRemaining = HControl.getPlayerOrder(nextPlayerTurn);
            }

            if (this.onTableMC.size() == 0 && firstTurn) { // if this player must go first
                SimpleCard tempCard = chooseRandomCard(this.intelligentMe);
                this.onTableMC.put(tempCard, this.intelligentMe);
//                Log.d("card_playing", "Player #" + this.intelligentMe.getPlayerNumber() + " plays " + tempCard.toString());

                firstCard = tempCard;
                firstTurn = false;

//                this.orderRemaining = HControl.getPlayerOrder(this.intelligentMe.getPlayerNumber());
            }

            for (Integer i: this.orderRemaining){
                for (MCPlayer mcP: this.allMCPlayers){
                    if (mcP.getPlayerNumber() == i.intValue()){
                        SimpleCard tempCard = chooseRandomCard(mcP);
                        this.onTableMC.put(tempCard, mcP); // plays random card and puts it on the table
//                        Log.d("card_playing", "Player #" + mcP.getPlayerNumber() + " plays " + tempCard.toString());

                        if (firstTurn && (mcP.getPlayerNumber() == intelligentMe.getPlayerNumber())) { // mcP.equals(intelligentMe) also should work? too lazy to test, my theory sucks :(
                            firstCard = tempCard;
                            firstTurn = false;
                        }
                    }
                }
            }


            endMiniRound(suiteToPlay);

        }

//        System.out.println("test");
//        Log.d("test","test");

//        Log.d("SIMULATED_SCORES_BEFORE", "The first card played was " + firstCard.toString());
//        for (MCPlayer p: allMCPlayers){
//            Log.d("SIMULATED_SCORES", p.getPlayerNumber() + "'s score is == " + p.getGameScore());
//        }

        return new Object[]{firstCard, this.intelligentMe.getGameScore()};




//        return playRound(null, mainPlayer, otherPlayersList);
    }

    // check HControl::endMiniRound() for comments
    private void endMiniRound(String originalSuite){

        int tempScore = 0;

        Iterator<SimpleCard> scoreCounterIter = this.onTableMC.keySet().iterator();

        while (scoreCounterIter.hasNext()){
            SimpleCard tempCard = scoreCounterIter.next();

            if (tempCard.getSuite().equalsIgnoreCase("hearts"))
                tempScore++;
            else if (tempCard.getStringValue().equalsIgnoreCase("queen") && tempCard.getSuite().equalsIgnoreCase("spades"))
                tempScore += 13;
        }

        Iterator<SimpleCard> tableSetIter = this.onTableMC.keySet().iterator();
        SimpleCard highestKey = tableSetIter.next();

        while (tableSetIter.hasNext()){
            SimpleCard tempKey = tableSetIter.next();

            if (!(highestKey.getSuite().equalsIgnoreCase(originalSuite))){
                Log.d("ENDROUND2", "old highestcard == " + highestKey.toString() + " -- new highestcard == " + tempKey.toString());
                highestKey = tempKey;
                continue;
            }

            if (highestKey.getSuite().equalsIgnoreCase(originalSuite) && tempKey.getSuite().equalsIgnoreCase(originalSuite)){
                if (!(highestKey.getIntValue() > tempKey.getIntValue())) {
                    Log.d("ENDROUND3", "old highestcard == " + highestKey.toString() + " -- new highestcard == " + tempKey.toString());
                    highestKey = tempKey;
                }
            }
        }

        MCPlayer takesHand;

//        try{
            takesHand = this.onTableMC.get(highestKey);
            nextPlayerTurn = takesHand.getPlayerNumber();
            takesHand.addScore(tempScore);
//        } catch (NullPointerException e) {}

        Log.d("card_playing_end", "Player #" + takesHand.getPlayerNumber() + " takes the hand with score of " + tempScore);

        this.onTableMC.clear();

        // bad practice?
//        if (intelligentMe.hasMoreCards())
//            return true; // if must continue to next hand
//        else
//            return false; // if must end round


    }


}
