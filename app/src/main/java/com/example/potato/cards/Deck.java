package com.example.potato.cards;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Potato on 6/6/2015.
 */

public class Deck{

    /*
    CARD PROPERTIES:
    w = 958px
    h = 1300px
    w:h = 0.4243:0.5757 == 1:1.3568 == 0.737:1
     */

    private ArrayList<Card> currentCards;
    private ArrayList<Card> currentCardsGraveyard;
    private ImageButton cardImage;

    private int currentSuite;
    private String[] cardFilesArray;
    private String gameName;
    private Context parentContext;

    // sets parameters for deck and stuff
    Deck(Context pContext, String game, String[] cardFiles, int suite) {
        parentContext = pContext;
        gameName = game;
        cardFilesArray = cardFiles;
        currentSuite = suite;
        currentCards = new ArrayList<>(52);
        currentCardsGraveyard = new ArrayList<>();

        String suiteName = "suite" + currentSuite;

        // NEEDED TO 'HARDCODE' CARD FILES == PUT FILES IN ARRAY BECAUSE IT'S FASTER THAN MISUSING THE RESOURCES() CLASS! BTW I USED A SCRIPT FOR THE NAMES SO NO REAL HARDCODING OK!!!!

        // THIS MEANS THAT SUITE WILL ONLY BE SET EVERY TIME DECK IS RESET == EVERY NEW GAME
        for (int i = 0; i < cardFilesArray.length; i++) {
            String[] fileName = cardFilesArray[i].split("_");
            String tempSuite = fileName[0];
            String tempValue = fileName[1];
            String tempCardSuiteNum = fileName[2];


            if (tempCardSuiteNum.equalsIgnoreCase(suiteName)) {
                cardImage = new ImageButton(parentContext);
//                cardImage.setBackground(parentContext.getResources().getDrawable(parentContext.getResources().getIdentifier(cardFilesArray[i], "drawable", parentContext.getPackageName())));
                currentCards.add(new Card(tempSuite, tempValue, gameName, cardImage));
                Log.d("ADDING @@@", "# " + tempSuite + " -- " + tempValue);
            }
        }
        Log.d("VALUE IS NOW!!@@", "" + currentCards.size());

    }


    public int getCurrentSuite() {
        return currentSuite;
    }



    // shuffles cards, can display values if you uncomment sutff
    public void shuffle(){

        // must add back cards from 'graveyard' after each 'round'
        if (currentCardsGraveyard.size() > 0)
            currentCards.addAll(currentCardsGraveyard);

//        StringBuilder temp = new StringBuilder();
//        for (Card s: this.currentCards){
//            temp.append(s.toString() + ", ");
//        }
//        Log.v("Deck!!!", "Before shuffling..." + temp);

        Collections.shuffle(this.currentCards, new Random());

//        StringBuilder temp2 = new StringBuilder();
//        for (Card s: currentCards){
//            temp2.append(s.toString() + ", ");
//        }
//        Log.v("Deck!!!", "After shuffling..." + temp2);

    }

    public int getNumCardsInDeck(){ // should always be 52!!! unless new rule or something
        return currentCards.size();
    }

    // graveyard actually just means that the card is in play/not in the deck anymore
    public Card getTopCard(){
        Card toReturn = currentCards.remove(0);
        currentCardsGraveyard.add(toReturn);
        return toReturn;
    }

    // gets all cards from graveyard and puts them in currentCards again
    public void resetCards(){
        int tempSize = currentCardsGraveyard.size();
        for (int i = 0; i < tempSize; i++)
            currentCards.add(currentCardsGraveyard.remove(0));
    }

    // removes all images from cards so they don't take up random memory
    public void resetCardImages(){
        // goes through all cards and removes image from layout + gets rid of its image
        for (int i = 0; i < currentCards.size(); i++){
            ImageView tempImage = currentCards.get(i).getImage();
            ViewGroup parentLayout = (ViewGroup) tempImage.getParent();


            try { // checking for null values initially doesn't work so this is needed
                if (parentLayout != null) {
//                    tempImage.setBackground(null);
                    parentLayout.removeView(tempImage);
                }
            } catch (Exception e){Log.d("DECK RESETIMAGE @@",e.getMessage()); }
        }
    }



}

