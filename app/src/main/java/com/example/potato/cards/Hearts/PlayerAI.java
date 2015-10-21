package com.example.potato.cards.Hearts;

import android.util.Log;
import android.view.animation.Animation;
import android.widget.TextView;

import com.example.potato.cards.Card_Engine.Card;
import com.example.potato.cards.MC_Intelligence.MCBrain;
import com.example.potato.cards.MC_Intelligence.MCNode;
import com.example.potato.cards.MC_Intelligence.MCPlayer;
import com.example.potato.cards.MC_Intelligence.MCPlayerIngelligent;
import com.example.potato.cards.MC_Intelligence.MCPlayerRandom;
import com.example.potato.cards.MC_Intelligence.SimpleCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.Iterator;

/**
 * Created by Potato on 6/7/2015.
 */
public class PlayerAI extends Player {


    Card toReturn;
    TextView scoreTextView;

    // sets relative locations
    PlayerAI(int playerNum, Animation animation, TextView scoreView) {
        this.playerNumber = playerNum;
        this.playerAnimation = animation;
        this.scoreTextView = scoreView;

        // assigns player to left, etc.
        switch (playerNum) {
            case 2:
                toLeft = 3;
                toRight = 1;
                toAcross = 4;
                break;
            case 3:
                toLeft = 4;
                toRight = 2;
                toAcross = 1;
                break;
            case 4:
                toLeft = 1;
                toRight = 3;
                toAcross = 2;
                break;
        }
    }

    // removes card completely from player's inventory/class
    @Override
    void eradicateCard(Card c) {
        if (heartsInHand.contains(c))
            heartsInHand.remove(c);
        else if (spadesInHand.contains(c))
            spadesInHand.remove(c);
        else if (clubsInHand.contains(c))
            clubsInHand.remove(c);
        else if (diamondsInHand.contains(c))
            diamondsInHand.remove(c);

        if (cardsInHand.contains(c))
            cardsInHand.remove(c);
    }

    @Override
    public Animation getPlayerAnimation() {
        return this.playerAnimation;
    }

    @Override
    public int getPlayerNumber() {
        return this.playerNumber;
    }

    @Override
    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
        scoreTextView.setText(String.valueOf(0));
    }

    @Override
    boolean isHuman() {
        return false;
    }

    public int getLeft() {
        return this.toLeft;
    }

    public int getRight() {
        return this.toRight;
    }

    public int getAcross() {
        return this.toAcross;
    }

    // adds both total gamescore and current round score
    @Override
    protected void addScore(int toAdd) {
        currentScore += toAdd;
        gameScore += toAdd;
        scoreTextView.setText(String.valueOf(currentScore));

    }

    // basic iterator returning stuff to use with AI

    private Card getHighestHeart() {
        HControl.heartsBroken = true;
        Iterator heartIt = heartsInHand.descendingIterator();
        toReturn = (Card) heartIt.next();
        heartIt.remove();
        return toReturn;
    }

    private Card getHighestSpade() {
        Iterator spadeIt = spadesInHand.descendingIterator();
        toReturn = (Card) spadeIt.next();
        spadeIt.remove();
        return toReturn;
    }

    private Card getHighestDiamond() {
        Iterator diamondIt = diamondsInHand.descendingIterator();
        toReturn = (Card) diamondIt.next();
        diamondIt.remove();
        return toReturn;
    }

    private Card getHighestClub() {
        Iterator clubsIt = clubsInHand.descendingIterator();
        toReturn = (Card) clubsIt.next();
        clubsIt.remove();
        return toReturn;
    }

    private Card getLowestHeart() {
        Iterator heartIt = heartsInHand.iterator();
        toReturn = (Card) heartIt.next();
        heartIt.remove();
        return toReturn;

    }

    private Card getLowestSpade() {
        Iterator spadeIt = spadesInHand.iterator();
        toReturn = (Card) spadeIt.next();
        spadeIt.remove();
        return toReturn;
    }

    private Card getLowestDiamond() {
        Iterator diaIt = diamondsInHand.iterator();
        toReturn = (Card) diaIt.next();
        diaIt.remove();
        return toReturn;

    }

    private Card getLowestClub() {
        Iterator clubIt = clubsInHand.iterator();
        toReturn = (Card) clubIt.next();
        clubIt.remove();
        return toReturn;
    }

    private Card tryToFindBlackQueen() {
        Iterator<Card> spadeIterator = spadesInHand.iterator();
        while (spadeIterator.hasNext()) {
            Card tempCard = spadeIterator.next();
            if (tempCard.getIntValue() == 13) {
                spadeIterator.remove();
                return tempCard;
            }
        }
        return null;
    }


    public ArrayList getIntersection(ArrayList one, ArrayList two){
        one.retainAll(two);
    }

    public SimpleCard chooseLegalNonVisitedChildCard(ArrayList<MCNode> visited, MCNode n, String suiteToPlay, boolean heartsBroken, int turnNum){

        boolean canPlayBQ;

        if (turnNum == 1)
            canPlayBQ = false;
        else
            canPlayBQ = true;

        ArrayList<MCNode> nodeChoices = new ArrayList<>((ArrayList<MCNode>) n.getChildMCNodes().clone()); // we know intersect.size() > 0 because !visitedAll
        nodeChoices.removeAll(visited);
        ArrayList<SimpleCard> cardChoices = n.getRestOfCards();

        if (turnNum == 1){
            for (SimpleCard c: cardChoices){
                if (c.getSuite().equalsIgnoreCase("clubs"))
                    return c;
            }

            for (SimpleCard c: cardChoices){
                if (c.getSuite().equalsIgnoreCase("diamonds") || (c.getSuite().equalsIgnoreCase("spades") &&  c.getIntValue() != 12) )
                    return c;
            }
        }

        // todo: for all other turns and stuff
        switch (suiteToPlay){
            case "none":
                break;
            case "clubs":
                for (SimpleCard c: cardChoices){
                    if (c.getSuite().equalsIgnoreCase("clubs"))
                        return c;
                }

                // if first turn, must play non-hearts and non-black queen
                if (turnNum == 1){
                    for (SimpleCard c: cardChoices){
                        if (c.getSuite().equalsIgnoreCase("diamonds") || (c.getSuite().equalsIgnoreCase("spades") && c.getIntValue() != 12))
                            return c;
                    }
                }
                break;
            case "diamonds":
            case "spades":
            case "hearts":
                for (SimpleCard c: cardChoices){
                    if (c.getSuite().equalsIgnoreCase(suiteToPlay))
                        return c;
                }
                break;
        }

        // this will be played if the respective card's suite doesn't exist in hand
        if (heartsBroken)
            return cardChoices.get((new Random()).nextInt(cardChoices.size()));
        else {
            for (SimpleCard c : cardChoices) {
                if (canPlayBQ) {
                    return c;
                } else {
                    if (!(c.getSuite().equalsIgnoreCase("spades") && c.getIntValue() == 12)) {
                        return c;
                    }
                }
            }
        }




    }


    public MCNode treePolicy(MCNode node, ArrayList<MCNode> visited,LinkedHashMap<Card, Player> onTheTable, String suiteToPlay, boolean heartsBroken, int turnNum){

        boolean visitedAll = true;

        ArrayList<MCNode> fringe = node.getChildMCNodes(); // i.e. all nodes that have been explored already

        // instead of this, can use intersect
        for (MCNode n: visited){
            if (!fringe.contains(n)){
                visitedAll = false;
                break;
            }
        }

        MCNode v;

        // if havent visited all, pick a random one that we havent visited yet
        if (!visitedAll){
            SimpleCard toPlay = chooseLegalNonVisitedChildCard(visited, node, suiteToPlay, heartsBroken, turnNum);
            v = new MCNode(toPlay, node.getRestOfCards());
            node.addChildNode(v);
        }
        else{ // i.e. if visitedAll, then
            v = bestChild(node, Math.sqrt(2));
        }

        return v;

    }

    private MCNode bestChild (MCNode n, double constant) {
        HashMap<Double, MCNode> allScores = new HashMap<>();

        for (int i = 0; i < n.getChildMCNodes().size(); i++) {
            MCNode child = n.getChildMCNodes().get(i);

            double reward = (1 - (child.getTotalRewards() / child.getTimesVisited())) // need (1 - average-score) because we are trying to minimize score, so because of that, highest reward = best card
                    + (constant * Math.sqrt((2 * Math.log(n.getTimesVisited())) / child.getTimesVisited()));

            allScores.put(reward, child);
        }

        // returns the highest scoring child node
        return allScores.get(Collections.max(allScores.keySet()));
    }


    private Double playRound(MCNode node){

    }


    public SimpleCard bestCardInTree(MCNode n){
        return null;
    }

    /*
    - descend from root node, choosing the highest valued node through UCB (if two are equal, pick randomly)
    - when reached node without children and that hasnt been visited before, add it to tree
    -
     */

    // TODO
    // i.e. if all child nodes has been visited more than N times, then we use UCB, otherwise random
    public int evaluateChildNodes(){
        return 0;
    }

    public SimpleCard mainMCTS(int time, MCPlayerIngelligent me, ArrayList<MCPlayerRandom> randomPlayers, String suiteToPlay, boolean heartsBroken, int turnNum, LinkedHashMap<Card, Player> onTable, ArrayList<Integer> orderRemaining){

        long startingTime = System.currentTimeMillis();

        MCNode rootNode = new MCNode(null, me.getCardsInHand());

        ArrayList<MCNode> visited = new ArrayList<>();

        // i.e. run loop for 2 seconds
        while ((startingTime + time) > System.currentTimeMillis()) {

            MCNode newNode = treePolicy(rootNode, visited, onTable, suiteToPlay, heartsBroken, turnNum);
            Double finalScoreAfterPlayout = playRound(newNode);

        }

        SimpleCard bestCardToPlay = bestCardInTree(rootNode);



        return bestCardToPlay;


    }



    public Card startIntelligentMonteCarloTurn(int turnNumber, String suiteToPlay, boolean heartsBroken, Player[] playerList, LinkedHashMap<Card, Player> onTable, ArrayList<Integer> order){

        // if first turn, must always play two of clubs, no choice here
        if (suiteToPlay.equalsIgnoreCase("clubs") && turnNumber == 1 && onTable.size() == 0) {
            Iterator<Card> it = clubsInHand.iterator();
            while (it.hasNext()) {
                Card tempCard = it.next();
                if (tempCard.getIntValue() == 2)
                    return tempCard;
            }
        }


        HashMap<SimpleCard, ArrayList<Integer>> cardWinRates = new HashMap<>(this.getCardsInHand().size());

//        for (int i = 0; i < 5; i++) {//

        // at beginning of every loop, need to make new MCPlayers
        MCPlayerIngelligent me = new MCPlayerIngelligent(this);
        ArrayList<MCPlayerRandom> randomPlayerList = new ArrayList<>(3);

        // add all players to list
        for (Player p : playerList) {
            MCPlayerRandom tempRandomPlayer = new MCPlayerRandom(p);

            if (p.getPlayerNumber() != this.getPlayerNumber()) // all players other than intelligent one
                randomPlayerList.add(tempRandomPlayer);
        }

        SimpleCard tempResults;


        // TODO: make all variables into one "State" dictionary or class for clarity
//        MCBrain mainGame = new MCBrain(me, randomPlayerList, suiteToPlay, heartsBroken, turnNumber, onTable, order);

        final int totalIterations = 2000; // ms

        tempResults = mainMCTS(totalIterations, me, randomPlayerList, suiteToPlay, heartsBroken, turnNumber, onTable, order);


        return tempResults;





//        tempResults = mainGame.playGame(); // should return array of 2 objects (card_played - SimpleCard, game_score - Integer)

//        try {
//            if (!(cardWinRates.containsKey(tempResults[0])))
//                cardWinRates.put((SimpleCard) tempResults[0], new ArrayList<Integer>());
//
//            cardWinRates.get(tempResults[0]).add((Integer) tempResults[1]);
//        } catch (ClassCastException e) {
//            Log.d("MC_FAIL", e.getMessage());
//        }

//        }

//
//        SimpleCard finalCard = null;
//
//
//        Log.d("AFTER_SIMULATIONS", "Best card to play is " + finalCard.toString() + " for player " + this.getPlayerNumber() + " with cards.." + this.cardsInHand.toString());
//
//        Card bestCard;
//
//        try{
//            bestCard = cardsInHand.get(cardsInHand.indexOf(finalCard));
//        } catch (Exception e){
//            Log.d("ERROR_END_TURN", e.getMessage());
//            throw new ArrayIndexOutOfBoundsException();
//        }
//
//        if (onTable.size() == 0)
//            HControl.mustPlaySuite = bestCard.getSuite();
//
////        return bestCard;
//        return null;
    }

    // for MC simulation, need all cards of players to simulate future turns
    // TODO: IF FIRST TURN, JUST FORCE PLAY TWO OF CLUBS
    public Card startIntelligentTurn(int turnNumber, String suiteToPlay, boolean heartsBroken, Player[] playerList, LinkedHashMap<Card, Player> onTable, ArrayList<Integer> order) {

        // if first turn, must always play two of clubs, no choice here
        if (suiteToPlay.equalsIgnoreCase("clubs") && turnNumber == 1 && onTable.size() == 0) {
            Iterator<Card> it = clubsInHand.iterator();
            while (it.hasNext()) {
                Card tempCard = it.next();
                if (tempCard.getIntValue() == 2)
                    return tempCard;
            }
        }


        HashMap<SimpleCard, ArrayList<Integer>> cardWinRates = new HashMap<>(this.getCardsInHand().size());

        for (int i = 0; i < 5; i++) {// TODO:::::: DEBUG TIME :((((((((

            // at beginning of every loop, need to make new MCPlayers
            MCPlayerIngelligent me = new MCPlayerIngelligent(this);
            ArrayList<MCPlayerRandom> randomPlayerList = new ArrayList<>(3);


            // add all players to list
            for (Player p : playerList) {
                MCPlayerRandom tempRandomPlayer = new MCPlayerRandom(p);

                if (p.getPlayerNumber() != this.getPlayerNumber()) // all players other than intelligent one
                    randomPlayerList.add(tempRandomPlayer);
            }

            // TODO: THIS IS PROBABLY BAD PRACTICE, NEED TO FIND SOMETHING LIKE A TUPLE THAT RETURNS 2 OBJECTS
            Object[] tempResults;


            MCBrain testGame = new MCBrain(me, randomPlayerList, suiteToPlay, heartsBroken, turnNumber, onTable, order);
            tempResults = testGame.playGame(); // should return array of 2 objects (card_played - SimpleCard, game_score - Integer)

            try {
                if (!(cardWinRates.containsKey(tempResults[0])))
                    cardWinRates.put((SimpleCard) tempResults[0], new ArrayList<Integer>());

                cardWinRates.get(tempResults[0]).add((Integer) tempResults[1]);
            } catch (ClassCastException e) {
                Log.d("MC_FAIL", e.getMessage());
            }

        }

        HashMap<SimpleCard, Integer> hm = getAverages(cardWinRates);
        Iterator<SimpleCard> it = hm.keySet().iterator();

        int tempLow = 0;
        SimpleCard finalCard = null;


        while (it.hasNext()) {
            SimpleCard temp = it.next();
            if (hm.get(temp).intValue() > tempLow) {
                finalCard = temp;
                tempLow = hm.get(temp).intValue();
            }

        }

        Log.d("AFTER_SIMULATIONS", "Best card to play is " + finalCard.toString() + " for player " + this.getPlayerNumber() + " with cards.." + this.cardsInHand.toString());

        Card bestCard;

        try{
            bestCard = cardsInHand.get(cardsInHand.indexOf(finalCard));
        } catch (Exception e){
            Log.d("ERROR_END_TURN", e.getMessage());
            throw new ArrayIndexOutOfBoundsException();
        }

        if (onTable.size() == 0)
            HControl.mustPlaySuite = bestCard.getSuite();

        return bestCard;

    }

    public HashMap<SimpleCard, Integer> getAverages(HashMap<SimpleCard, ArrayList<Integer>> origCardWinRates) {
        Iterator<SimpleCard> it = origCardWinRates.keySet().iterator();
        HashMap<SimpleCard, Integer> finalHashMap = new HashMap<>();

        while (it.hasNext()) {
            SimpleCard tempC = it.next();
            int tempSum = 0;

            for (Integer i : origCardWinRates.get(tempC))
                tempSum += i.intValue();

            tempSum /= origCardWinRates.get(tempC).size();

            finalHashMap.put(tempC, new Integer(tempSum));
        }

        return finalHashMap;
    }


    // TODO: UPDATE CHOICES BASED ON TURN NUMBER
    // LOWER TURN = GET RID OF HIGH CARDS
    // IF SPADES QUEEN/KING/ACE PLAY SPECIAL

    // for now, just basic ai -- 1) play lowest card of available suite, 2) otherwise play a heart if turn > 1, 3) play highest card from other suite (diamonds first, then clubs)
    @Override
    public Card startTurn(int turnNumber, String suiteToPlay, boolean heartsBroken, LinkedHashMap<Card, Player> onTable) {

        // this whole if clause is for when AI is first person to play a card
        if (suiteToPlay.equalsIgnoreCase("none")) { // meaning it's your turn
            if (spadesInHand.size() > 5 && (tryToFindBlackQueen() == null)) { // if you have a lot of spades, try to flush out whoever has the queen
                HControl.mustPlaySuite = "spades";
                return getLowestSpade();
            }
            if (heartsBroken) {
                Iterator<Card> heartsIt = heartsInHand.iterator();
                while (heartsIt.hasNext()) {
                    Card tempCard = heartsIt.next();
                    if (tempCard.getIntValue() > 7) {
                        break;
                    } else {
                        HControl.mustPlaySuite = "hearts";
                        heartsIt.remove();
                        return tempCard;
                    }
                }
            }
            if (clubsInHand.size() > 0) {
                HControl.mustPlaySuite = "clubs";
                return getLowestClub();
            }
            if (diamondsInHand.size() > 0) {
                HControl.mustPlaySuite = "diamonds";
                return getLowestDiamond();
            }
            if (heartsBroken && heartsInHand.size() > 0) {
                HControl.mustPlaySuite = "hearts";
                return getLowestHeart();
            }
            if (spadesInHand.size() > 0) {
                HControl.mustPlaySuite = "spades";
                return getLowestSpade();
            }
            if (!heartsBroken && heartsInHand.size() > 0) {
                HControl.heartsBroken = true;
                HControl.mustPlaySuite = "hearts";
                return getLowestHeart();
            }

        }


        // the following clauses are for reacting to other cards
        if (suiteToPlay.equalsIgnoreCase("spades")) {

            boolean hasBlackQueen = false; // use this somehow? not sure
            boolean hasHigherThanQueenSpade = false;

            // if someone puts queen and you have a lower spade, use it
            for (Card key : onTable.keySet()) {

                if (key.getSuite().equalsIgnoreCase("spades") && key.getIntValue() > 12) {
                    hasHigherThanQueenSpade = true;
                }

                if (key.getSuite().equalsIgnoreCase("spades") && key.getStringValue().equalsIgnoreCase("queen")) {
                    hasBlackQueen = true;
                    for (Card x : spadesInHand) {
                        if (x.getIntValue() < key.getIntValue())
                            return getLowestSpade();
                    }
                }
            }

            // if someone has a higher card than black queen then you let them take the hit
            if (hasHigherThanQueenSpade) {
                Card toPotentiallyReturn = tryToFindBlackQueen();
                if (!(toPotentiallyReturn == null))
                    return toPotentiallyReturn;
            }


            if (spadesInHand.size() > 0) {
                return getLowestSpade();
            }
            if (turnNumber > 1) {
                if (heartsInHand.size() > 0)
                    return getHighestHeart();
            }
            if (diamondsInHand.size() > 0) {
                return getHighestDiamond();

            }
            if (clubsInHand.size() > 0) {
                return getHighestClub();
            }
        } else if (suiteToPlay.equalsIgnoreCase("diamonds")) {
            if (diamondsInHand.size() > 0) {
                return getLowestDiamond();
            }
            if (spadesInHand.size() > 0) { // try to get rid of black queen ASAP -- attempt to look for it
                Card toPossiblyReturn = tryToFindBlackQueen();
                if (toPossiblyReturn != null)
                    return toPossiblyReturn;

            }
            if (heartsInHand.size() > 0) {
                return getHighestHeart();
            }
            if (clubsInHand.size() > 0) {
                return getHighestClub();
            }
            if (spadesInHand.size() > 0) {
                return getHighestSpade();
            }
        } else if (suiteToPlay.equalsIgnoreCase("clubs")) {

            // whoever has 2 of clubs must play it, that person will already be assigned to play first anyway
            if (clubsInHand.size() > 0) {
                Iterator tempIt = clubsInHand.iterator();
                if (((Card) tempIt.next()).getIntValue() == 2)
                    return getLowestClub();
            }


            // first turn you can get rid of cards easily for no cost because hearts cannot be played
            if (turnNumber == 1) {
                if (clubsInHand.size() > 0)
                    return getHighestClub();
                if (diamondsInHand.size() > 0)
                    return getHighestDiamond();
                if (spadesInHand.size() > 0)
                    return getHighestSpade();
            }


            if (clubsInHand.size() > 0)
                return getLowestClub();


            if (spadesInHand.size() > 0) { // try to get rid of black queen ASAP -- attempt to look for it
                Card toPossiblyReturn = tryToFindBlackQueen();
                if (toPossiblyReturn != null)
                    return toPossiblyReturn;
            }
            if (heartsInHand.size() > 0) {
                return getHighestHeart();
            }
            if (diamondsInHand.size() > 0) {
                return getHighestDiamond();
            }
            if (spadesInHand.size() > 0) {
                return getHighestSpade();
            }

        } else if (suiteToPlay.equalsIgnoreCase("hearts")) {
            if (heartsInHand.size() > 0) {
                return getLowestHeart();
            }
            if (spadesInHand.size() > 0) { // try to get rid of black queen ASAP -- attempt to look for it
                Card toPossiblyReturn = tryToFindBlackQueen();
                if (toPossiblyReturn != null)
                    return toPossiblyReturn;
            }
            if (clubsInHand.size() > 0) {
                return getHighestClub();
            }
            if (diamondsInHand.size() > 0) {
                return getHighestDiamond();
            }
            if (spadesInHand.size() > 0) {
                return getHighestSpade();
            }

        }

        Log.d("HORRIBLE AI", ":( idk what happened -- " + suiteToPlay + " -- " + onTable.toString());
        return null;
    }


    // for now, pick the three highest valued cards, after black queen
    // TODO:: CHOOSE HIGHEST HEARTS ETC. TO PASS
    @Override
    public void chooseCardsToPass() {
//        for (int i = 0;i < 3; i++){

        cardsToPass.add(cardsInHand.get(0));
        cardsToPass.add(cardsInHand.get(1));

        boolean queenDetected = false;

        Collections.sort(cardsInHand); // sort by natural order = lowest first
        Collections.reverse(cardsInHand); // reverse that == highest fi rst

        for (int x = 0; x < cardsInHand.size(); x++) {
            if (cardsInHand.get(x).getSuite().equalsIgnoreCase("spades") && cardsInHand.get(x).getStringValue().equalsIgnoreCase("queen")) {
                cardsToPass.add(cardsInHand.get(x));
                queenDetected = true;
                break;
            }
        }

        if (!queenDetected) {
            cardsToPass.add(cardsInHand.get(2));
        }

        for (int c = 0; c < cardsToPass.size(); c++)
            eradicateCard(cardsToPass.get(c)); // removes it from the player


//            cardsToPass.add(getRemoveRandomCardFromHand());
//        }
    }


    @Override
    ArrayList<Card> getCardsToPass() {
        return this.cardsToPass;
    }
}

