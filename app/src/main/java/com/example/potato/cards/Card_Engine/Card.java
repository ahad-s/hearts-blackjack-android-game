package com.example.potato.cards.Card_Engine;

import android.widget.ImageButton;

/**
 * Created by Potato on 6/6/2015.
 */
public class Card implements Comparable {

    protected String suite;
    protected int intValue;
    protected String stringValue;
    private String game; // diff values for hearts/blackjack
    private ImageButton image;


    public Card(String suite, String stringValue, String game, ImageButton cardButton){
        this.suite = suite;
        this.stringValue = stringValue;
        this.game = game;
        this.intValue = returnIntValue(stringValue, game);
        this.image = cardButton;
    }

    public String getGame() {
        return game;
    }

    public String getStringValue() {
        return stringValue;
    }

    public String getSuite() {
        return suite;
    }



    public void setImage(ImageButton image) {
        this.image = image;
    }

    // converts string value to int value depending on game (blackjack or hearts)
    private static int returnIntValue(String s, String game){
        int val = 0;

        if (s.equalsIgnoreCase("one"))
            val = 1;
        else if (s.equalsIgnoreCase("two"))
            val = 2;
        else if (s.equalsIgnoreCase("three"))
            val = 3;
        else if (s.equalsIgnoreCase("four"))
            val = 4;
        else if (s.equalsIgnoreCase("five"))
            val = 5;
        else if (s.equalsIgnoreCase("six"))
            val = 6;
        else if (s.equalsIgnoreCase("seven"))
            val = 7;
        else if (s.equalsIgnoreCase("eight"))
            val = 8;
        else if (s.equalsIgnoreCase("nine"))
            val = 9;

        if (game.equalsIgnoreCase("blackjack")) {
            if (s.equalsIgnoreCase("ten") || s.equalsIgnoreCase("jack") || s.equalsIgnoreCase("queen") || s.equalsIgnoreCase("king")) // all considered equal in blackjack
                val = 10;
            if (s.equalsIgnoreCase("ace")) {
                val = 11;
            }
        }
        else if (game.equalsIgnoreCase("hearts")){
            if (s.equalsIgnoreCase("ten"))
                val = 10;
            else if (s.equalsIgnoreCase("jack"))
                val = 11;
            else if (s.equalsIgnoreCase("queen"))
                val = 12;
            else if (s.equalsIgnoreCase("king"))
                val = 13;
            else if (s.equalsIgnoreCase("ace"))
                    val = 14;
            }

        return val;
    }

    public ImageButton getImage() {
        return image;
    }

    public int getIntValue() {
        return intValue;
    }

    public boolean hasThisImage(ImageButton x){
        return x.equals(this.getImage());
    }

    // need to override this stuff!
    @Override
    public String toString() {
        return getSuite() + " -- " + getStringValue();
    }

    @Override
    public boolean equals(Object o){

        if (!(o instanceof Card))
            return false;

        if (o == null)
            return false;

        Card c = (Card) o;

        String one = c.getSuite() + "_" + c.getStringValue();
        String two = this.getSuite() + "_" + this.getStringValue();

        return one.equalsIgnoreCase(two);

    }

    @Override
    public int hashCode(){
        int hashFactor = 11; // random factor
        String hashString = this.getSuite() + "_" + this.getStringValue();
        int hashInt = hashFactor * hashString.hashCode();
        return hashInt;

    }

    // Cards are compared a lot in program so natural order is important here
    // 'lowest' tier cards left -- 'highest' tier right -- CLUBS, DIAMONDS, SPADES, HEARTS
    public int compareTo(Object tempO){

        if (tempO instanceof Card == false)
            throw new ClassCastException();

        Card other = (Card) tempO;
        String one = this.getSuite() + "_" + this.getStringValue();
        String two = other.getSuite() + "_" + other.getStringValue();

        if (this.getSuite().equals(other.getSuite())){
            if (this.getIntValue() > other.getIntValue())
                return 1;
            else if (this.getIntValue() < other.getIntValue())
                return -1;
            else
                return 0; // should never happen omg
        }
        else if (!this.getSuite().equalsIgnoreCase(other.getSuite())){
            switch (this.getSuite()){
                case "clubs":
                    return -1;
                case "hearts":
                    return 1;
                case "diamonds":
                    if (this.getSuite().equalsIgnoreCase("clubs"))
                        return -1;
                    else
                        return 1;
                case "spades":
                    if (this.getSuite().equalsIgnoreCase("hearts"))
                        return 1;
                    else
                        return -1;
                default:
                    return 0;
            }
        }

        return two.toString().compareToIgnoreCase(one.toString());

//        if (this.getIntValue() > other.getIntValue())
//            return 1; // this places the lower card near the 'front' of the 'queue' == lower index, so it's ascending in order of value
//        else if (this.getIntValue() < other.getIntValue())
//            return -1;
//        else { // should never occur when only comparing two suites, but will code incase occurs
//            Log.d("CARD COMPARE", "NOT SUPPOSED TO HAPPEN@@@");
//            return 0;
//            switch (other.getSuite()){
//                case "clubs":
//                    return -1;
//                case "hearts":
//                    return 1;
//                case "diamonds":
//                    if (this.getSuite().equalsIgnoreCase("clubs"))
//                        return -1;
//                    else
//                        return 1;
//                case "spades":
//                    if (this.getSuite().equalsIgnoreCase("hearts"))
//                        return 1;
//                    else
//                        return -1;
//                default:
//                    return 0;
//            }
//        }
    }
}
