package com.example.potato.cards.MC_Intelligence;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

/**
 * Created by Potato on 8/12/2015.
 */
public abstract class MCPlayer {

    protected int currentScore = 0;
    protected int gameScore = 0;

    int playerNumber;

    ArrayList<SimpleCard> cardsInHand = new ArrayList(13);

    ArrayList<SimpleCard> clubsInHand = new ArrayList();
    ArrayList<SimpleCard> diamondsInHand = new ArrayList();
    ArrayList<SimpleCard> spadesInHand = new ArrayList();
    ArrayList<SimpleCard> heartsInHand = new ArrayList();

    Random r;

    MCPlayer(){
        r = new Random();
    }

    public ArrayList<SimpleCard> getCardsInHand() {
        return cardsInHand;
    }

    protected int getGameScore() {
        return gameScore;
    }

    protected int getCurrentScore() {
        return currentScore;
    }

    void arrangeCards(){
        cardsInHand.clear();

        cardsInHand.addAll(clubsInHand);
        cardsInHand.addAll(diamondsInHand);
        cardsInHand.addAll(spadesInHand);
        cardsInHand.addAll(heartsInHand);
    }

    protected void addCard(SimpleCard c) {
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

    public int getPlayerNumber() {
        return playerNumber;
    }

    public boolean hasMoreCards(){
        if (cardsInHand.size() > 0)
            return true;
        return false;
    }

    // return a random card after removing it from heartsInHand AND cardsInHand
    // if player doesn't have that card to play, they are allowed to play any card except on first turn
    public SimpleCard playRandomHeart(){
        if (heartsInHand.size() == 0)
            return playRandomCard();

        SimpleCard toRemove = heartsInHand.remove(r.nextInt(heartsInHand.size()));
        cardsInHand.remove(toRemove);
        return toRemove;
    }

    public SimpleCard playRandomClub(int turn){
        if (clubsInHand.size() == 0){
            // hearts cannot be played on the first turn if player doesn't have club
            if (turn == 1) {
                return playRandomNonHeartsCard(turn);
            }

            return playRandomCard();
        }

        SimpleCard toRemove = clubsInHand.remove(r.nextInt(clubsInHand.size()));
        cardsInHand.remove(toRemove);
        return toRemove;
    }

    public SimpleCard playRandomDiamond(){
        if (diamondsInHand.size() == 0)
            return playRandomCard();

        SimpleCard toRemove = diamondsInHand.remove(r.nextInt(diamondsInHand.size()));
        cardsInHand.remove(toRemove);
        return toRemove;
    }

    public SimpleCard playRandomSpade(int turn){
        if (spadesInHand.size() == 0)
            return playRandomCard();

        SimpleCard toRemove;

        // if first turn, can't play queen of spades
        if (turn == 1){
            toRemove = spadesInHand.get(r.nextInt(spadesInHand.size()));
            if (toRemove.getIntValue() == 12)
                return playRandomCard();
        }

        toRemove = spadesInHand.remove(r.nextInt(spadesInHand.size()));
        cardsInHand.remove(toRemove);
        return toRemove;
    }

    public SimpleCard playRandomCard(){
        SimpleCard toRemove = cardsInHand.remove(r.nextInt(cardsInHand.size()));
        switch (toRemove.getSuite()){
            case "hearts":
                heartsInHand.remove(toRemove);
                break;
            case "spades":
                spadesInHand.remove(toRemove);
                break;
            case "diamonds":
                diamondsInHand.remove(toRemove);
                break;
            case "clubs":
                clubsInHand.remove(toRemove);
                break;
        }
        return toRemove;
    }

    public SimpleCard playRandomNonHeartsCard(int turn){
        int suiteSelect = r.nextInt(3);
        switch (suiteSelect){
            case 2:
                return playRandomSpade(turn); // this is different from playRandomClub(1) since it only applies to first turn
            case 1:
                return playRandomDiamond();
            case 0:
                return playRandomClub(1); // need turn to == 1 because that means must try to choose randomnonheartscard
        }
        return null;
    }


    public SimpleCard playTwoOfClubs(){
        for (SimpleCard c: clubsInHand)
            if (c.getIntValue() == 2) {
                SimpleCard toRemove = clubsInHand.remove(clubsInHand.indexOf(c));
                cardsInHand.remove(toRemove);
                return toRemove;
            }
        return null;
    }


    void addScore(int score){
        gameScore += score;
        currentScore += score;
    }
}
