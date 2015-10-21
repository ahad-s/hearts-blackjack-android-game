package com.example.potato.cards.MC_Intelligence;

import com.example.potato.cards.Card_Engine.*;

/**
 * Created by Potato on 8/12/2015.
 */
public class SimpleCard extends Card {
    /*
    This will be used in the simulation w/o image to save time/etc. (hopefully)
     */

    SimpleCard(Card cardToCopy){
        super(cardToCopy.getSuite(), cardToCopy.getStringValue(), cardToCopy.getGame(), null);
    }


}
