package com.example.potato.cards;

import android.util.Log;
import android.view.animation.Animation;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.Iterator;

/**
 * Created by Potato on 6/7/2015.
 */
public class PlayerAI extends Player{


    Card toReturn;
    TextView scoreTextView;

    // sets relative locations
    PlayerAI(int playerNum, Animation animation, TextView scoreView){
        this.playerNumber = playerNum;
        this.playerAnimation = animation;
        this.scoreTextView = scoreView;

        // assigns player to left, etc.
        switch (playerNum){
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

    public int getLeft(){
        return this.toLeft;
    }

    public int getRight(){
        return this.toRight;
    }

    public int getAcross(){
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

    private Card getHighestHeart(){
        HControl.heartsBroken = true;
        Iterator heartIt = heartsInHand.descendingIterator();
        toReturn = (Card) heartIt.next();
        heartIt.remove();
        return toReturn;
    }

    private Card getHighestSpade(){
        Iterator spadeIt = spadesInHand.descendingIterator();
        toReturn = (Card) spadeIt.next();
        spadeIt.remove();
        return toReturn;
    }

    private Card getHighestDiamond(){
        Iterator diamondIt = diamondsInHand.descendingIterator();
        toReturn = (Card) diamondIt.next();
        diamondIt.remove();
        return toReturn;
    }

    private Card getHighestClub(){
        Iterator clubsIt = clubsInHand.descendingIterator();
        toReturn = (Card) clubsIt.next();
        clubsIt.remove();
        return toReturn;
    }

    private Card getLowestHeart(){
        Iterator heartIt = heartsInHand.iterator();
        toReturn = (Card) heartIt.next();
        heartIt.remove();
        return toReturn;

    }

    private Card getLowestSpade(){
        Iterator spadeIt = spadesInHand.iterator();
        toReturn = (Card) spadeIt.next();
        spadeIt.remove();
        return toReturn;
    }

    private Card getLowestDiamond(){
        Iterator diaIt = diamondsInHand.iterator();
        toReturn = (Card) diaIt.next();
        diaIt.remove();
        return toReturn;

    }

    private Card getLowestClub(){
        Iterator clubIt = clubsInHand.iterator();
        toReturn = (Card) clubIt.next();
        clubIt.remove();
        return toReturn;
    }

    private Card tryToFindBlackQueen(){
        Iterator<Card> spadeIterator = spadesInHand.iterator();
        while (spadeIterator.hasNext()){
            Card tempCard = spadeIterator.next();
            if (tempCard.getIntValue() == 13){
                spadeIterator.remove();
                return tempCard;
            }
        }
        return null;
    }



    // TODO: UPDATE CHOICES BASED ON TURN NUMBER
    // LOWER TURN = GET RID OF HIGH CARDS
    // IF SPADES QUEEN/KING/ACE PLAY SPECIAL

    // for now, just basic ai -- 1) play lowest card of available suite, 2) otherwise play a heart if turn > 1, 3) play highest card from other suite (diamonds first, then clubs)
    @Override
    public Card startTurn(int turnNumber, String suiteToPlay, boolean heartsBroken, TreeMap<Card, Player> onTable) {

        // this whole if clause is for when AI is first person to play a card
        if (suiteToPlay.equalsIgnoreCase("none")){ // meaning it's your turn
            if (spadesInHand.size() > 5 && (tryToFindBlackQueen() == null)){ // if you have a lot of spades, try to flush out whoever has the queen
                HControl.mustPlaySuite = "spades";
                return getLowestSpade();
            }
            if (heartsBroken){
                Iterator<Card> heartsIt = heartsInHand.iterator();
                while (heartsIt.hasNext()){
                    Card tempCard = heartsIt.next();
                    if (tempCard.getIntValue() > 7){
                        break;
                    }
                    else {
                        HControl.mustPlaySuite = "hearts";
                        heartsIt.remove();
                        return tempCard;
                    }
                }
            }
            if (clubsInHand.size() > 0){
                HControl.mustPlaySuite = "clubs";
                return getLowestClub();
            }
            if (diamondsInHand.size() > 0){
                HControl.mustPlaySuite = "diamonds";
                return getLowestDiamond();
            }
            if (heartsBroken && heartsInHand.size() > 0) {
                HControl.mustPlaySuite = "hearts";
                return getLowestHeart();
            }
            if (spadesInHand.size() > 0){
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
        if (suiteToPlay.equalsIgnoreCase("spades")){

            boolean hasBlackQueen = false; // use this somehow? not sure
            boolean hasHigherThanQueenSpade = false;

            // if someone puts queen and you have a lower spade, use it
            for (Card key: onTable.keySet()){

                if (key.getSuite().equalsIgnoreCase("spades") && key.getIntValue() > 12){
                    hasHigherThanQueenSpade = true;
                }

                if (key.getSuite().equalsIgnoreCase("spades") && key.getStringValue().equalsIgnoreCase("queen")){
                    hasBlackQueen = true;
                    for (Card x: spadesInHand){
                        if (x.getIntValue() < key.getIntValue())
                            return getLowestSpade();
                    }
                }
            }

            // if someone has a higher card than black queen then you let them take the hit
            if (hasHigherThanQueenSpade){
                Card toPotentiallyReturn = tryToFindBlackQueen();
                if (!(toPotentiallyReturn == null))
                    return toPotentiallyReturn;
            }



            if (spadesInHand.size() > 0) {
                return getLowestSpade();
            }
            if (turnNumber > 1){
                if (heartsInHand.size() > 0)
                    return getHighestHeart();
            }
            if (diamondsInHand.size() > 0){
                return getHighestDiamond();

            }
            if (clubsInHand.size() > 0){
                return getHighestClub();
            }
        }
        else if (suiteToPlay.equalsIgnoreCase("diamonds")){
            if (diamondsInHand.size() > 0){
                return getLowestDiamond();
            }
            if (spadesInHand.size() > 0){ // try to get rid of black queen ASAP -- attempt to look for it
                Card toPossiblyReturn = tryToFindBlackQueen();
                if (toPossiblyReturn != null)
                    return toPossiblyReturn;

            }
            if (heartsInHand.size() > 0){
                return getHighestHeart();
            }
            if (clubsInHand.size() > 0){
                return getHighestClub();
            }
            if (spadesInHand.size() > 0){
                return getHighestSpade();
            }
        }
        else if (suiteToPlay.equalsIgnoreCase("clubs")){

            // whoever has 2 of clubs must play it, that person will already be assigned to play first anyway
            if (clubsInHand.size() > 0) {
                Iterator tempIt = clubsInHand.iterator();
                if (((Card)tempIt.next()).getIntValue() == 2)
                    return getLowestClub();
            }


            // first turn you can get rid of cards easily for no cost because hearts cannot be played
            if (turnNumber == 1){
                if (clubsInHand.size() > 0)
                    return getHighestClub();
                if (diamondsInHand.size() > 0)
                    return getHighestDiamond();
                if (spadesInHand.size() > 0)
                    return getHighestSpade();
            }


            if (clubsInHand.size() > 0)
                return getLowestClub();


            if (spadesInHand.size() > 0){ // try to get rid of black queen ASAP -- attempt to look for it
                Card toPossiblyReturn = tryToFindBlackQueen();
                if (toPossiblyReturn != null)
                    return toPossiblyReturn;
            }
            if (heartsInHand.size() > 0){
                return getHighestHeart();
            }
            if (diamondsInHand.size() > 0){
                return getHighestDiamond();
            }
            if (spadesInHand.size() > 0){
                return getHighestSpade();
            }

        }
        else if (suiteToPlay.equalsIgnoreCase("hearts")){
            if (heartsInHand.size() > 0){
                return getLowestHeart();
            }
            if (spadesInHand.size() > 0){ // try to get rid of black queen ASAP -- attempt to look for it
                Card toPossiblyReturn = tryToFindBlackQueen();
                if (toPossiblyReturn != null)
                    return toPossiblyReturn;
            }
            if (clubsInHand.size() > 0){
                return getHighestClub();
            }
            if (diamondsInHand.size() > 0){
                return getHighestDiamond();
            }
            if (spadesInHand.size() > 0){
                return getHighestSpade();
            }

        }

        Log.d("HORRIBLE AI", ":( idk what happened -- " +suiteToPlay + " -- " + onTable.toString());
        return null;
    }




    // for now, pick the three highest valued cards, after black queen
    @Override
    public void chooseCardsToPass() {
//        for (int i = 0;i < 3; i++){

            cardsToPass.add(cardsInHand.get(0));
            cardsToPass.add(cardsInHand.get(1));

            boolean queenDetected = false;

            Collections.sort(cardsInHand); // sort by natural order = lowest first
            Collections.reverse(cardsInHand); // reverse that == highest fi rst

            for (int x = 0; x < cardsInHand.size(); x++){
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

