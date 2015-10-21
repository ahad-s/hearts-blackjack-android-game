package com.example.potato.cards.Hearts;
import com.example.potato.cards.Card_Engine.*;

import android.view.animation.Animation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by Potato on 6/7/2015.
 */
public abstract class Player{


    // this class is used by AI and Human player in Hearts game
    // sets basic stuff like relative locations, hardcoded for now since only 4 players

    //TODO::: Change all "cardsInHand.size() > 0" to "hasMoreCards()"


    int currentScore = 0;
    int gameScore = 0;

    protected int toLeft;
    protected int toRight;
    protected int toAcross;

    Animation playerAnimation;

    ArrayList<Card> cardsInHand = new ArrayList<>(13);

    int playerNumber;

    ArrayList<Card> cardsToPass = new ArrayList<>(3);

    public int getGameScore() {
        return gameScore;
    }

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }


    TreeSet<Card> clubsInHand = new TreeSet<>();
    TreeSet<Card> diamondsInHand = new TreeSet<>();
    TreeSet<Card> spadesInHand = new TreeSet<>();
    TreeSet<Card> heartsInHand = new TreeSet<>();


    abstract void addScore(int score);

    abstract void eradicateCard(Card c);



    protected void resetCardList(){
        clubsInHand.clear();
        diamondsInHand.clear();
        spadesInHand.clear();
        heartsInHand.clear();

        cardsInHand.clear();
    }


    // important stuff for human/ai constructors
    abstract public int getPlayerNumber();
    abstract public int getLeft();
    abstract public int getRight();
    abstract public int getAcross();
    abstract public Animation getPlayerAnimation();

    abstract public void chooseCardsToPass();

    abstract boolean isHuman();

    abstract ArrayList<Card> getCardsToPass();

    abstract public Card startTurn(int turnNumber, String mustPlaySuite, boolean heartsBroken, LinkedHashMap<Card, Player> onTable); // this will just return the card that the AI should play


    protected void passCardsTo(ArrayList<Card> toAddFrom, Player receiver){
        Iterator<Card> cardIterator = toAddFrom.iterator();

        while (cardIterator.hasNext()) {
            receiver.addCard(cardIterator.next()); // adds a reference of the next element to receiver's cardlist
            cardIterator.remove(); // removes it from the original hand
        }
        // arranges receiver's cards
        receiver.arrangeCards();
    }




    // adds card to the respective set
    protected void addCard(Card c) {
        switch(c.getSuite()){
            case "hearts":
                heartsInHand.add(c);
                break;
            case "clubs":
                clubsInHand.add(c);
                break;
            case "spades":
                spadesInHand.add(c);
                break;
            case "diamonds":
                diamondsInHand.add(c);
        }

    }

    public boolean hasMoreCards(){
        if (cardsInHand.size() > 0)
            return true;
        return false;
    }

    protected boolean hasCardInHand(String suite, String value){
        for (int i = 0; i < cardsInHand.size(); i++){
            if (cardsInHand.get(i).getSuite().equalsIgnoreCase(suite) && cardsInHand.get(i).getStringValue().equalsIgnoreCase(value))
                return true;
        }

        return false;
    }


    // removes a random card from hand, used for testing mostly
//    protected Card getRemoveRandomCardFromHand(){
//        Random r = new Random();
//        int indexToRetrieve = r.nextInt(cardsInHand.size());
//        Card toRemove = cardsInHand.remove(indexToRetrieve);
//
//        if (clubsInHand.contains(toRemove))
//           clubsInHand.remove(toRemove);
//
//        if (heartsInHand.contains(toRemove))
//            heartsInHand.remove(toRemove);
//
//        if (spadesInHand.contains(toRemove))
//            spadesInHand.remove(toRemove);
//
//        if (diamondsInHand.contains(toRemove))
//            diamondsInHand.remove(toRemove);
//
//        return toRemove;
//
//    }

    // this is done in another piece so the respective suite sets aren't 'anonymous'
    void arrangeCards(){
        cardsInHand.clear();

        cardsInHand.addAll(clubsInHand);
        cardsInHand.addAll(diamondsInHand);
        cardsInHand.addAll(spadesInHand);
        cardsInHand.addAll(heartsInHand);
    }

    public ArrayList<Card> getCardsInHand() {
        return cardsInHand;
    }

    public int getCurrentScore() {
        return currentScore;
    }



}

