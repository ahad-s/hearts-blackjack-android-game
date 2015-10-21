package com.example.potato.cards.MC_Intelligence;


import com.example.potato.cards.Card_Engine.*;
import com.example.potato.cards.Hearts.*;

/**
 * Created by Potato on 8/12/2015.
 */
public class MCPlayerRandom extends MCPlayer {

    public MCPlayerRandom(Player p){

        super();

        for (Card c: p.getCardsInHand())
            this.addCard(new SimpleCard(c));

        this.playerNumber = p.getPlayerNumber();

        arrangeCards();


    }
}
