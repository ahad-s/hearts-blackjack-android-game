package com.example.potato.cards.Blackjack;

import com.example.potato.cards.Card_Engine.Card;

import java.util.ArrayList;

/**
 * Created by Potato on 6/11/2015.
 */


// main purpose of this class is just to keep track of the money and cards that the player has
public class PlayerBlackjack {

    // for statistics? add later into sql database for storage maybe
    int currentSessionScore = 0; // how much they
    private int totalMoney;
    int numWins;
    int numLosses;

    ArrayList<Card> currentCards;
    private int currentHandScore = 0;

    PlayerBlackjack(int currentTotalMoney){
        currentCards = new ArrayList<>(2);
        totalMoney =  currentTotalMoney;
    }

    // adds card to arraylist and updates total score
    public void addCard(Card newCard){
        int tempScoreToAdd = newCard.getIntValue();

        this.currentHandScore += tempScoreToAdd;

        currentCards.add(newCard);


    }


    public void setCurrentHandScore(int currentHandScore) {
        this.currentHandScore = currentHandScore;
    }

    public int getCurrentHandScore() {
        return currentHandScore;
    }
}
