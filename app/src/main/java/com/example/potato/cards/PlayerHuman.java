package com.example.potato.cards;

import android.view.animation.Animation;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Created by Potato on 6/6/2015.
 */
public class PlayerHuman extends Player{


    private ArrayList<Card> cardsToPass;
    TextView scoreTextView;

    // basic constructor stuff
    PlayerHuman(ArrayList<Card> cardsToPass, Animation animation, TextView scoreView){
        this.cardsToPass = cardsToPass;
        this.playerNumber = 1;
        this.playerAnimation = animation;
        this.scoreTextView = scoreView;

        this.toLeft = 2;
        this.toRight = 4;
        this.toAcross = 3;
    }

    public TextView getScoreTextView() {
        return scoreTextView;
    }

    @Override
    public int getPlayerNumber() {
        return this.playerNumber;
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

    @Override
    public Animation getPlayerAnimation() {
        return this.playerAnimation;
    }

    @Override
    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
        scoreTextView.setText(String.valueOf(0));
    }

    @Override
    void addScore(int toAdd) {
        currentScore += toAdd;
        gameScore += toAdd;
        scoreTextView.setText(String.valueOf(currentScore));
    }

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
    public Card startTurn(int turnNum, String suiteToPlay, boolean heartsBroken, LinkedHashMap<Card, Player> onTable) { // ?? no
        return null;
    }

    // only needed for AI
    @Override
    public void chooseCardsToPass() {
    }

    @Override
    boolean isHuman() {
        return true;
    }

    // just removes stuff, kind of like eradicate()
    @Override
    ArrayList<Card> getCardsToPass() {
        ArrayList<Card> temp = new ArrayList<>();

        Iterator cardIter = cardsToPass.iterator();

        while (cardIter.hasNext()){
            Card toPassOn = (Card) cardIter.next();

            if (cardsInHand.contains(toPassOn))
                cardsInHand.remove(toPassOn);

            if (spadesInHand.contains(toPassOn))
                spadesInHand.remove(toPassOn);

            if (clubsInHand.contains(toPassOn))
                clubsInHand.remove(toPassOn);

            if (diamondsInHand.contains(toPassOn))
                diamondsInHand.remove(toPassOn);

            if (heartsInHand.contains(toPassOn))
                heartsInHand.remove(toPassOn);

            temp.add(toPassOn);
            cardIter.remove();
        }

        return temp;
    }
}
