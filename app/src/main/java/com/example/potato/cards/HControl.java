package com.example.potato.cards;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Created by Potato on 6/6/2015.
 */
public class HControl extends FragmentActivity{


    /*
    Pass phase - select 3 cards and pass them -- boolean will == true when 3 cards are selected, then press image on screen ("PASS LEFT/RIGHT/etc")
    First turn - find player who has 2 of clubs, and they play first, then left of them, then left of them..etc
    Every turn after that -
     */

    final int NUM_PLAYERS = 4;
    final int MAX_PASSING_CARDS = 3;
    int selectedToPass = 0;


    private Deck gameDeck;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor prefEditor;
    private int currentSuite;
    static boolean heartsBroken; // true == broken, false == not broken yet in round
    boolean inPassPhase = false;

    Intent scoreBoardIntent;

    int gameRound = 0;


    int playerTurn;
    int miniRoundTurnNumber;

    private DisplayMetrics dm;
    private Display display;

    Player[] players;
    Player humanPlayer;
    private int totalWins;
    private int totalLosses;

    Animation moveToHandAnimation;
    ViewGroup cardSpaceLayout;
    int cardSpaceLayoutHeight;
    ImageButton tempChild;

    ArrayList<Card> tempToPass = new ArrayList<>(3);
    boolean passLeft = true;
    boolean passRight = false;
    boolean passAcross = false;
    boolean passNone = false;
    boolean passPhaseGlowActivated = false;

    ArrayList<Integer> playersTurnsLeft = new ArrayList<>();

    ImageView passArrow;

    ImageView mustSelectThreeCardsImage;

    RelativeLayout heartsGameLayout;

    HashMap<Integer, ArrayList<Integer>> totalGameScoreMap = new HashMap<>();

    // comparator is reverse of natural order of card since we just want the highest value of a suite
    LinkedHashMap<Card, Player> currentCardsOnTable = new LinkedHashMap<>();

    TextView jamieTextView;
    TextView dianeTextView;
    TextView mikeyTextView;
    TextView humanTextView;

    static String mustPlaySuite;

    Animation pushDownIn;
    Animation pushUpIn;
    Animation pushRightIn;
    Animation pushLeftIn;

    String[] cardFiles;

    boolean makeAvailable = true;

    boolean firstTurn = false;



    // usual oncreate stuff, references to views
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.heartsgame);

        // assignments and stuff for stuff
        sharedPreferences = getSharedPreferences(MainActivity.DEFAULT_SHARED_DATABASE, MODE_PRIVATE);
        prefEditor = sharedPreferences.edit();

        passArrow = (ImageView) findViewById(R.id.arrow_pass);
        mustSelectThreeCardsImage = (ImageView) findViewById(R.id.must_select_three_cards);

        currentSuite = sharedPreferences.getInt("current_suite", MainActivity.DEFAULT_INT_VALUE);
        totalWins = sharedPreferences.getInt("total_wins_hearts", MainActivity.DEFAULT_INT_VALUE);
        totalLosses = sharedPreferences.getInt("total_losses_hearts", MainActivity.DEFAULT_INT_VALUE);

        scoreBoardIntent = new Intent(HControl.this, ScoreBoard.class);

        heartsGameLayout = (RelativeLayout) findViewById(R.id.heartsgame_layout);
        cardSpaceLayout = (ViewGroup) findViewById(R.id.current_hand_space);

        pushDownIn = AnimationUtils.loadAnimation(this, R.anim.push_down_in);
        pushUpIn = AnimationUtils.loadAnimation(this, R.anim.push_up_in);
        pushRightIn = AnimationUtils.loadAnimation(this, R.anim.push_right_in);
        pushLeftIn = AnimationUtils.loadAnimation(this, R.anim.push_left_in);

        jamieTextView = (TextView) findViewById(R.id.jamie_scoreview);
        dianeTextView = (TextView) findViewById(R.id.diane_scoreview);
        mikeyTextView = (TextView) findViewById(R.id.mikey_scoreview);
        humanTextView = (TextView) findViewById(R.id.hearts_player_score_view);

        ImageView settingsButton = (ImageView) findViewById(R.id.hearts_settings_button);
        ImageView scoreButton = (ImageView) findViewById(R.id.score_button);

        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showUpdatedScoreBoard();
            }
        });



        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HControl.this, SettingsMenu.class));
            }
        });



        display = getWindowManager().getDefaultDisplay();
        dm = new DisplayMetrics();
        display.getMetrics(dm);




        passArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tempToPass.size() == 3) {
                    passPhaseFinish();
                } else {
                    mustPassThreeCards();
                }
            }
        });

        // TODO: ADD SECOND SUITE
        if (currentSuite == 1)
            cardFiles = getResources().getStringArray(R.array.suite_1_cards);
        else if (currentSuite == 2)
            cardFiles = getResources().getStringArray(R.array.suite_2_cards);


        players = new Player[NUM_PLAYERS];

        // populate players + preset animations and textviews
        humanPlayer = new PlayerHuman(tempToPass, pushUpIn, humanTextView);

        players[0] = humanPlayer;
        players[1] = new PlayerAI(2, pushRightIn, mikeyTextView);
        players[2] = new PlayerAI(3, pushDownIn, dianeTextView);
        players[3] = new PlayerAI(4, pushLeftIn, jamieTextView);


        // to test end stuff
//        for (Player p: players){
//            p.setGameScore(90);
//        }




        // only lets app go through when it's far enough in the life cycle that the relativelayout for the cards is fully built
        cardSpaceLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                cardSpaceLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                cardSpaceLayoutHeight = cardSpaceLayout.getHeight();
                //must do at beginning of each round

                nextPassingRoundStart();

//                resetGame();
//                distributeCardsToPlayers();
            }
        });



    }


    private void resetGame(){
        gameDeck = new Deck(this.getApplicationContext(), "hearts", cardFiles, currentSuite);

        inPassPhase = true;

        // have to do this at beginning of each round
        gameDeck.resetCards();
        gameDeck.resetCardImages();

        for (Player p: players)
            p.resetCardList();

        gameDeck.shuffle();

        int numCards = gameDeck.getNumCardsInDeck() / players.length; // 52 cards for 4 players == should be 13 cards each
        for (int i = 0; i < numCards; i++){
            for (Player p: players)
                p.addCard(gameDeck.getTopCard());

        }
        // must put all cards into list "cardsInHand()" to pass cards later etc.
        for (Player p: players) {
            p.arrangeCards();
        }


    }

    private void distributeCardsToPlayers(){ // just distributes visually to humans

        cardSpaceLayout.removeAllViews();

        ImageButton cardImage;
        Card currentCard;

        // adds all cards in hand to cardspace_layout
        for (int i = 0; i < humanPlayer.getCardsInHand().size(); i++){
            currentCard = humanPlayer.getCardsInHand().get(i);

            cardImage = currentCard.getImage();
            cardImage.setAdjustViewBounds(true);

            String ident = currentCard.getSuite() + "_" + currentCard.getStringValue() + "_suite" + gameDeck.getCurrentSuite();
            cardImage.setBackground(getResources().getDrawable(getResources().getIdentifier(ident, "drawable", getPackageName())));
            cardImage.setVisibility(View.INVISIBLE);
            cardImage.setId(View.generateViewId()); // I SPENT 2 HOURS TRYING TO FIGURE OUT WHY MY CODE WORKING -- REALIZED YOU NEED TO SET YOUR OWN ID TO DYNAMICALLY GENERATED VIEWS omg

            cardSpaceLayout.addView(cardImage, new RelativeLayout.LayoutParams(Math.round(cardSpaceLayoutHeight * 1.2f * 0.737f), Math.round(cardSpaceLayoutHeight * 1.2f)));

        }


        if (gameRound == 2){
            System.out.println("d");
        }

        // start of "pass phase" and setting up cards
        if (inPassPhase) // should only happen once at beginning of a round, and is set to true again after the deck is shuffled/"resetGame" is called
            adjustAllViews();


        // TODO: ADD ANIMATIONS FOR CARDS COMING IN
//        moveToHandAnimation = AnimationUtils.loadAnimation(this, R.anim.push_right_in);
//        for (int i = 0; i < cardSpaceLayout.getChildCount(); i++) {
//            tempChild = (ImageButton) cardSpaceLayout.getChildAt(i);
//            tempChild.setVisibility(View.VISIBLE);
//        }

    }

    /*

     */

    private void translateFromHandToTable(ImageButton cardButton){

        cardButton.bringToFront();

        int[] location = new int[2];
        cardButton.getLocationInWindow(location);

        float deltaX = dm.widthPixels / 2 - location[0] - 35 * dm.density;
        float deltaY = location[1] - dm.heightPixels / 2 - 18 * dm.density;

        TranslateAnimation moveToTableAnim = new TranslateAnimation(0, deltaX, 0, -deltaY );
        moveToTableAnim.setFillAfter(true);
        moveToTableAnim.setDuration(400);
//        moveToTableAnim.setInterpolator(new LinearInterpolator()); // TODO: CHANGE THIS ALONG WITH AI

        cardButton.startAnimation(moveToTableAnim);

    }

    private ArrayList<Integer> getPlayerOrder(int startingPlayerTurn){

        ArrayList<Integer> temp = new ArrayList();

        if (startingPlayerTurn == 1){
            temp.add(1); temp.add(2); temp.add(3); temp.add(4);
            return temp;
        }
        else if (startingPlayerTurn == 2){
            temp.add(2); temp.add(3); temp.add(4); temp.add(1);
            return temp;
        }
        else if (startingPlayerTurn == 3){
            temp.add(3); temp.add(4); temp.add(1); temp.add(2);
            return temp;
        }
        else{
            temp.add(4); temp.add(1); temp.add(2); temp.add(3);
            return temp;
        }
    }





    // use for when round starts
    // removes card and aligns the rest of the cards properly -- sort of like removing a card and then dynamically readjusting every card that isn't in place
    private void removeCardProperly(View v){

        int toRemove = cardSpaceLayout.indexOfChild(v);
        if (toRemove == 0){
            if (cardSpaceLayout.getChildCount() > 1) {
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(cardSpaceLayout.getChildAt(toRemove + 1).getLayoutParams());
                params.removeRule(RelativeLayout.RIGHT_OF);
                params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                params.setMargins(0, 0, 0, 0);
                cardSpaceLayout.getChildAt(toRemove + 1).setLayoutParams(params);

                translateFromHandToTable((ImageButton) v);
            }
            else
                translateFromHandToTable((ImageButton) v);


        }
        else{

            if (toRemove != cardSpaceLayout.getChildCount() - 1) {
                ImageButton onRight = (ImageButton) cardSpaceLayout.getChildAt(toRemove + 1);
                ImageButton onLeft = (ImageButton) cardSpaceLayout.getChildAt(toRemove - 1);

                translateFromHandToTable((ImageButton) v);

                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(onRight.getLayoutParams());
                params.removeRule(RelativeLayout.RIGHT_OF);
                params.addRule(RelativeLayout.RIGHT_OF, onLeft.getId());
                params.leftMargin -= Math.round(40 * dm.density);
                onRight.setLayoutParams(params);

            }
            else{
                translateFromHandToTable((ImageButton) v);

            }
        }

    }





    // decide who gets the points - hardcoded since only 4 cards in play
    // mini round = after people play 4 cards
    private void endMiniRound(String originalSuite){

        originalSuite = mustPlaySuite;
        int tempScore = 0;
        Iterator scoreCounterIter = currentCardsOnTable.keySet().iterator();

        while (scoreCounterIter.hasNext()){
            Card tempC = (Card) scoreCounterIter.next();

//            tempC.getImage().setVisibility(View.GONE); // TAKES UP TOO MUCH MEMORY, NEED TO REMOVE!!

            if (tempC.getSuite().equalsIgnoreCase("hearts")){
                tempScore++;
            }
            else if (tempC.getSuite().equalsIgnoreCase("spades") && tempC.getStringValue().equalsIgnoreCase("queen")){
                tempScore += 13;
            }
            tempC.getImage().setImageBitmap(null);
        }

        // starts the cycle all over again -- NOT HERE
//        nextPassingRoundStart();


        // checks if the first 3 are the same suite and assigns values, otherwise the last one has to be the same suite
        Iterator tableSetIter = currentCardsOnTable.keySet().iterator();
        Card highestKey = (Card) tableSetIter.next();

        Log.d("ENDROUND0", "current suite -- " + originalSuite);

        Iterator tempit = currentCardsOnTable.keySet().iterator();

        while (tempit.hasNext()){
            Card tempk = (Card) tempit.next();
            Log.d("ENDROUND1", "cards on table -- " + tempk.getSuite() + " -- " + tempk.getStringValue());
        }

        while (tableSetIter.hasNext()){
            Card tempKey = (Card) tableSetIter.next();

            if (!(highestKey.getSuite().equalsIgnoreCase(originalSuite))){
                Log.d("ENDROUND2", "old highestcard == " + highestKey.toString() + " -- new highestcard == " + tempKey.toString());
                highestKey = tempKey;
                continue;
            }

            if (highestKey.getSuite().equalsIgnoreCase(originalSuite) && tempKey.getSuite().equalsIgnoreCase(originalSuite)){
                if (!(highestKey.getIntValue() > tempKey.getIntValue())) {
                    Log.d("ENDROUND3", "old highestcard == " + highestKey.toString() + " -- new highestcard == " + tempKey.toString());
                    highestKey = tempKey;
                }
            }

        }

        try {
            Player takesHand = currentCardsOnTable.get(highestKey);
            playerTurn = takesHand.getPlayerNumber();
            takesHand.addScore(tempScore);
        } catch (NullPointerException e ) {}

//        Log.d("SCORING", "Player " + takesHand.getPlayerNumber() + " gained a score of " + tempScore);

        Iterator tableCardsIt = currentCardsOnTable.keySet().iterator();
        // remove all cards from table
        while (tableCardsIt.hasNext()){
            // TODO: ADD ANIMATION TO MOVE CARDS TOWARDS WHOEVER LOST THE HAND
            Card toRemoveFromTable = (Card) tableCardsIt.next();
            toRemoveFromTable.getImage().setVisibility(View.GONE);

            Player tempP = currentCardsOnTable.get(toRemoveFromTable);

            if (tempP != null){
                tempP.eradicateCard(toRemoveFromTable);
            }
        }

        currentCardsOnTable.clear();

        Log.d("TURN", "IT IS NOW PLAYER " + playerTurn + "'s TURN TO START!");

        playerPlayedAlready = false;

        if (humanPlayer.getCardsInHand().size() > 0 )
            miniRoundStart(miniRoundTurnNumber);
        else
            newRound();


    }


    private void addCardToTable(ImageButton image, Player owner){
        Card toPutOnTable = getCardAssociatedWithImage(owner, image);
        currentCardsOnTable.put(toPutOnTable, owner);


    }


    private boolean hasSuite(Player p, String suiteToPlay){
        for (int i = 0; i < p.getCardsInHand().size(); i++){
            if (p.getCardsInHand().get(i).getSuite().equalsIgnoreCase(suiteToPlay))
                return true;
        }
        return false;
    }



    // since this is called quite often, it is easy to change onclicklisteners
    private void humanPlayerSpecialTurn(final int miniRoundTurnNumber, int inc,  final String suiteToPlay, boolean heartsBroken){

        if (gameRound == 2){
            System.out.println("testing2");
        }

        if (inc == 1)
            firstTurn = true;

        makeAvailable = true;

        for (int i = 0; i < cardSpaceLayout.getChildCount(); i++) {
            ImageButton tempButton = (ImageButton) cardSpaceLayout.getChildAt(i);
            final boolean tempHeartsBroken = heartsBroken;

//            if (inc == 1) { // if first turn
//                try {
//                    mustPlaySuite = getCardAssociatedWithImage(humanPlayer, tempButton).getSuite();
//                    Log.d("NEWSUITE", "THE NEXT SUITE IS..." + mustPlaySuite);
//                } catch (NullPointerException e) {
//                    Log.d("LISTENER NULL POINTER", e.getMessage());
//                }
//                inc++;
//            }

            tempButton.setOnClickListener(null);
            Drawable tempDraw = tempButton.getBackground();
            tempDraw.setColorFilter(0xBB000000, PorterDuff.Mode.SCREEN);
            tempButton.setBackground(tempDraw);

            Card tempC = getCardAssociatedWithImage(humanPlayer, tempButton);

            if (tempC.getSuite().equalsIgnoreCase(mustPlaySuite) || mustPlaySuite.equalsIgnoreCase("none") || !hasSuite(humanPlayer, mustPlaySuite)) {


                // if suite is hearts and it hasn't been broken and player has other cards available to play
                if (tempC.getSuite().equalsIgnoreCase("hearts") && !heartsBroken && hasSuite(humanPlayer, "spades") && hasSuite(humanPlayer, "spades") && hasSuite(humanPlayer, "diamonds"))
                    continue;

                if (tempC.getSuite().equalsIgnoreCase("hearts") && miniRoundTurnNumber == 1)
                    continue;

                // if first turn and card is not clubs, cannot play it
                if (miniRoundTurnNumber == 1 && firstTurn){
                    if (!(tempC.getSuite().equalsIgnoreCase("clubs") && tempC.getStringValue().equalsIgnoreCase("two"))){
                        continue;
                    }
                }

                tempDraw = tempButton.getBackground();
                tempDraw.setColorFilter(null);
                tempButton.setBackground(tempDraw);

                tempButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        if (gameRound == 2){
                            System.out.println("potato");
                            Log.d("IT WORKS!!!!!!!", "going good so far, makeavail -- " + makeAvailable);

                        }

                        if (makeAvailable) {

                            if (firstTurn) { // if first turn
                                try {
                                    mustPlaySuite = getCardAssociatedWithImage(humanPlayer, v).getSuite();
                                    Log.d("NEWSUITE", "THE NEXT SUITE IS..." + mustPlaySuite);
                                } catch (NullPointerException e) {
                                    Log.d("LISTENER NULL POINTER", e.getMessage());
                                }
                                firstTurn = false;
                            }

                            removeCardProperly(v);
                            addCardToTable((ImageButton) v, humanPlayer);

                            // makes all cards unavailable after you use one
                            makeAvailable = false;


                            // continue with the AI that still need to do their turn then set a new Handler() to return cards and start next round after 5 seconds~
                            if (playersTurnsLeft.size() > 0) { // this means that there is more than just the player left to still play the game, since passing arraylist it won't include original
                                Iterator<Integer> playerTurnsIterator = playersTurnsLeft.iterator();

                                while (playerTurnsIterator.hasNext()) { // while more turns need to be done
                                    Integer turnOfPlayer = playerTurnsIterator.next();
                                    Card toPlay;
                                    switch (turnOfPlayer) {
                                        case 2:
                                        case 3:
                                        case 4:
                                            toPlay = players[turnOfPlayer - 1].startTurn(miniRoundTurnNumber, mustPlaySuite, tempHeartsBroken, currentCardsOnTable);
                                            aiPlayerTurn(toPlay, players[turnOfPlayer - 1]);
                                            break;
                                    }
                                }

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Log.d("ROUND STUFF", "Ending round..Starting endMiniRound()");
                                        endMiniRound(suiteToPlay);
                                    }
                                }, 3000); // by default = 2000-4000ms
                            } else {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Log.d("ROUND STUFF", "Ending round..Starting endMiniRound()");
                                        endMiniRound(suiteToPlay);
                                    }
                                }, 3000);

                            }

                        }
                    }
                });

            }

        }

    }

    int delay = 0;

    // sets translation for ai player card to come in its respective side
    private void aiPlayerTurn(Card cardToPlay, final Player bot){

        delay++;

        final ImageButton tempImage = cardToPlay.getImage();

        String ident = cardToPlay.getSuite() + "_" + cardToPlay.getStringValue() + "_suite" + gameDeck.getCurrentSuite();
        tempImage.setBackground(getResources().getDrawable(getResources().getIdentifier(ident, "drawable", getPackageName())));

        heartsGameLayout.addView(tempImage);


        // use layoutparams from other cards
        RelativeLayout.LayoutParams newParams = new RelativeLayout.LayoutParams(Math.round(cardSpaceLayoutHeight * 0.737f), Math.round(cardSpaceLayoutHeight));

        newParams.addRule(RelativeLayout.CENTER_VERTICAL);
        newParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        tempImage.setLayoutParams(newParams);

        if (bot.getPlayerNumber() == 2) {
            tempImage.setX(tempImage.getX() - 30 * dm.density);
        }
        else if (bot.getPlayerNumber() == 3){
            tempImage.setY(tempImage.getY() - 30 * dm.density);
        }
        else if (bot.getPlayerNumber() == 4) {
            tempImage.setX(tempImage.getX() + 30 * dm.density);
        }

//        tempImage.bringToFront();
        addCardToTable(tempImage, bot);

        // TODO: ADD BETTER INTERPOLATORS FOR AI + HUMAN
//        bot.getPlayerAnimation().setInterpolator(new LinearInterpolator());

        tempImage.startAnimation(bot.getPlayerAnimation());



        if (delay == 3)
            delay = 0;


        Log.d("BOT POWER", "Player " + bot.getPlayerNumber() + " is playing card: " + cardToPlay.toString());
        Log.d("CURRENT_SUITE_MUST", mustPlaySuite);


    }

    // to implement if shutting off game is annoying
    private void endGamePopUp(boolean win){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(HControl.this);
        if (win)
            dialogBuilder.setTitle("WOOHOO! YOU WON!");
        else
            dialogBuilder.setTitle("A+ for effort!");
        dialogBuilder.setMessage("Do you want to play again?");
        dialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent heartsActivityIntent = new Intent(HControl.this, HControl.class);
                heartsActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(heartsActivityIntent);
            }
        });
        dialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent mainActivityIntent = new Intent(HControl.this, MainActivity.class);
                mainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainActivityIntent);

            }
        });

        dialogBuilder.setIcon(R.drawable.blue_button);

        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }

    boolean gameOver;

    private void showUpdatedScoreBoard(){
        // currently it redraws the scoreboard every time scoreBoardIntent is reactivated with a static map
        // TODO: Hide ScoreBoard activity instead of rewriting all rows for efficiency
        if (totalGameScoreMap.size() > 0 ) {
            scoreBoardIntent.putIntegerArrayListExtra("newscores", totalGameScoreMap.get(gameRound));
            scoreBoardIntent.putExtra("gameround", gameRound);
        }
        startActivity(scoreBoardIntent);
    }


    boolean win = false;
    boolean showingDialog = false;

    // prepares for new round or ends game if someone has >100 score
    private void newRound(){

        ArrayList<Integer> scores = new ArrayList<Integer>();
        totalGameScoreMap.put(gameRound, scores); // totalgamescoremap has a reference to scores, so it'll automatically update as we update scores

        miniRoundTurnNumber = 0;

        win = false;
        boolean gameOver = false;
        makeAvailable = true;

        // keep these in order -- human, mikey, diane, jamie or something
        for (Player p : players){
            scores.add(p.getCurrentScore()); // no need for new Integer since currentScore is just int == no reference carried over
            p.setCurrentScore(0);

            Log.d("PLAYERGAMESCORE" , "Player #" + p.getPlayerNumber() + " -- " + p.getGameScore());

            if (p.getGameScore() >= 100){
                gameOver = true;
                win = humanPlayer.getGameScore() < 100;
            }

        }

        for (int i = 0; i < humanPlayer.getCardsInHand().size(); i++){
            ImageButton tempButton =  humanPlayer.getCardsInHand().get(i).getImage();
            tempButton.setVisibility(View.GONE);
        }

        showUpdatedScoreBoard();



        if (gameOver){
            showingDialog = false;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

//                    if (!showingDialog) {
//                        showingDialog = true;

                        ScoreBoard.resetTotalScores(); // need to clear static variable

                        // this clears any activity on top of it on the stack after starting mainactivity
//                    Intent mainActivityIntent = new Intent(HControl.this, MainActivity.class);
//                    mainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(mainActivityIntent);

                        endGamePopUp(win);
//                    }


                }
            }, 3000); // ends game after 10 seconds

//            while (ScoreBoard.isVisible()){
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e){}
//            }
//
//            if (!showingDialog) {
//                ScoreBoard.resetTotalScores();
//                endGamePopUp(win);
//            }

        }
        else{
            // Checks every 0.5s to see if the user closed the scoreboard
//            try {
//                while (!ScoreBoard.isVisible()) {
//                    Thread.sleep(500);
//                }
//            } catch (InterruptedException e) {}
            nextPassingRoundStart();

        }


    }



    boolean playerPlayedAlready = false;

    private void miniRoundStart(int turn){

        if (!inPassPhase) {
//            if (humanPlayer.getCardsInHand().size() == 0) {
//                newRound();
//            }

            if (gameRound == 2){
                System.out.println("test");
            }

            mustPlaySuite = "none";

            humanPlayer.arrangeCards();
            distributeCardsToPlayers();
            adjustAllViews();

            miniRoundTurnNumber++;

            if (miniRoundTurnNumber == 1) {
                mustPlaySuite = "clubs";

                for (Player p : players) {
                    if (p.hasCardInHand("clubs", "two")) {
                        playerTurn = p.getPlayerNumber();
                        break;
                    }
                }

            } else {
                mustPlaySuite = "none";
                Log.d("TESTING", "TEST " + miniRoundTurnNumber);
            }

            ArrayList<Integer> orderPlay = getPlayerOrder(playerTurn);
            Iterator<Integer> orderPlayIter = orderPlay.iterator();
            Card toPlay;
            int i = 0;

            while (orderPlayIter.hasNext() && !playerPlayedAlready) {
                Integer turnOfPlayer = orderPlayIter.next();
                orderPlayIter.remove();
                i++;
                switch (turnOfPlayer) {
                    case 1:
                        // when player turn starts, this loop doesn't iterate anymore and ai turns will be initiated by the orderPlay.tailSet
                        playersTurnsLeft = orderPlay;
                        humanPlayerSpecialTurn(miniRoundTurnNumber, i, mustPlaySuite, heartsBroken);
                        playerPlayedAlready = true;
                        break;
                    case 2:
                    case 3:
                    case 4:
                        toPlay = players[turnOfPlayer - 1].startTurn(miniRoundTurnNumber, mustPlaySuite, heartsBroken, currentCardsOnTable);
                        aiPlayerTurn(toPlay, players[turnOfPlayer - 1]);
                        break;
                }

                if (playerPlayedAlready) { // stop the loop and let player do his turn
                    break;
                }
            }
        }





    }




    private void resetTranslation(){
        for (int i = 0; i < cardSpaceLayout.getChildCount(); i++){
            cardSpaceLayout.getChildAt(i).setTranslationX(0);
            cardSpaceLayout.getChildAt(i).setTranslationY(0);
        }
    }

    private void nextPassingRoundStart(){
        gameRound++;

        heartsBroken = false;
        mustPlaySuite = "none";
        inPassPhase = true;
        passArrow.setVisibility(View.VISIBLE);
        selectedToPass = 0;
        playerPlayedAlready = false;

        resetGame();
        distributeCardsToPlayers();
//        adjustAllViews();
        resetTranslation();
        passPhaseDeActivate();


        // removes the outer lining on cards
        for (int i = 0; i < cardSpaceLayout.getChildCount(); i++){
            ImageButton temp = (ImageButton) cardSpaceLayout.getChildAt(i);
            Drawable toFix = temp.getBackground();
            toFix.setColorFilter(null);
            temp.setBackground(toFix);
        }

    }






    // reserved for failure
    private void imGonnaFail(){
        for (int i = 0; i < cardSpaceLayout.getChildCount(); i++){
            Log.d("@@@@", Math.round(cardSpaceLayoutHeight * 0.737f) + " -- " +  cardSpaceLayoutHeight);
            Log.d("####", Math.round(cardSpaceLayout.getHeight() * 0.737f) + " -- " +  cardSpaceLayout.getHeight());
            RelativeLayout.LayoutParams temp = new RelativeLayout.LayoutParams(Math.round(cardSpaceLayoutHeight * 0.737f), Math.round(cardSpaceLayoutHeight));
//            RelativeLayout.LayoutParams temp = new RelativeLayout.LayoutParams(Math.round(cardSpaceLayoutHeight * 0.737f), cardSpaceLayoutHeight);
            ImageButton tempB = (ImageButton) cardSpaceLayout.getChildAt(i);
            tempB.setLayoutParams(temp);
            tempB.setVisibility(View.VISIBLE);
        }
    }



    // dynamically resets view for the beginning of a hand
    private void adjustAllViews(){
        for (int i = 0; i < cardSpaceLayout.getChildCount(); i++){
            tempChild = (ImageButton) cardSpaceLayout.getChildAt(i);
            RelativeLayout.LayoutParams newParams = new RelativeLayout.LayoutParams(Math.round(cardSpaceLayoutHeight * 1.2f * 0.737f), Math.round(cardSpaceLayoutHeight * 1.2f));
//            RelativeLayout.LayoutParams newParams = new RelativeLayout.LayoutParams(tempChild.getLayoutParams());
            newParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

            if (i != 0) {
                newParams.addRule(RelativeLayout.RIGHT_OF, cardSpaceLayout.getChildAt(i - 1).getId());
                newParams.setMargins(-Math.round(40 * dm.density), 0, 0, 0);
            }
            else {
                newParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            }


            tempChild.setLayoutParams(newParams);
            tempChild.setVisibility(View.VISIBLE);
            tempChild.setScaleType(ImageView.ScaleType.FIT_XY);

            Drawable tempBK = tempChild.getBackground();
            tempChild.setColorFilter(null);
            tempChild.setBackground(tempBK);

            // why??? TODO: CHECK THIS
//            tempChild.setOnClickListener(null);


            if (inPassPhase) {

                Log.d("ADJUSTVIEWS", "SETTING PASSING LISTENERS");
                tempChild.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {



                        if (inPassPhase) {
                            if (!tempToPass.contains(getCardAssociatedWithImage(humanPlayer, v))) {
                                addPotentialCardToPass(v);
                            } else if (tempToPass.contains(getCardAssociatedWithImage(humanPlayer, v))) {
                                removePotentialCardToPass(v);
                            }
                        } else { // if in round phase

                            Log.d("WTF IS THIS @@@", "OMG ASDFASDFASDFASDF");
                            // TODO: IF IS PLAYER TURN, THEN CAN PLAY CARD
                        }
                    }
                });
            }


//            tempChild.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });


        }

    }

    private void passPhaseFinish(){

        passArrow.setVisibility(View.GONE);
        inPassPhase = false;

        if (passLeft){
            // need to do this before passing starts because human might get the cards he originally passed
            for (Player p: players) {
                p.chooseCardsToPass();
            }

            for (Player p: players){
                try {
                    p.passCardsTo(p.getCardsToPass(), players[p.getLeft() - 1]); // have to do p.toLeft-1 since all player numbers assume 1, 2, 3, 4
                } catch (ArrayIndexOutOfBoundsException e){Log.d("PASSING_ERROR", e.getMessage());}

                Log.d("PASSING1", "Player " + p.getPlayerNumber() + " passing to -- " + p.getLeft());
            }


            Log.d("PLAYER1", players[0].getCardsInHand().toString());
            Log.d("PLAYER2", players[1].getCardsInHand().toString());
            Log.d("PLAYER3", players[2].getCardsInHand().toString());
            Log.d("PLAYER4", players[3].getCardsInHand().toString());


            miniRoundStart(miniRoundTurnNumber = 0);

//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    nextPassingRoundStart();
//
//                }
//            },4000);

            passLeft = false;
            passRight = true;

        }
        else if (passRight){
            for (Player p: players) {
                p.chooseCardsToPass();
            }

            for (Player p: players){
                try {
                    p.passCardsTo(p.getCardsToPass(), players[p.getRight() - 1]); // have to do p.toLeft-1 since all player numbers assume 1, 2, 3, 4
                } catch (ArrayIndexOutOfBoundsException e){Log.d("PASSING_ERROR", e.getMessage());}

                Log.d("PASSING1", "Player " + p.getPlayerNumber() + " passing to -- " + p.getRight());
            }


            Log.d("PLAYER1", players[0].getCardsInHand().toString());
            Log.d("PLAYER2", players[1].getCardsInHand().toString());
            Log.d("PLAYER3", players[2].getCardsInHand().toString());
            Log.d("PLAYER4", players[3].getCardsInHand().toString());

            miniRoundStart(miniRoundTurnNumber);


//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    nextPassingRoundStart();
//
//                }
//            }, 4000);

            miniRoundStart(miniRoundTurnNumber = 0);

            passRight = false;
            passAcross = true;

        }
        else if (passAcross){
            for (Player p: players) {
                p.chooseCardsToPass();
            }

            for (Player p: players){
                try {
                    p.passCardsTo(p.getCardsToPass(), players[p.getAcross() - 1]); // have to do p.toLeft-1 since all player numbers assume 1, 2, 3, 4
                } catch (ArrayIndexOutOfBoundsException e){Log.d("PASSING_ERROR", e.getMessage());}

                Log.d("PASSING1", "Player " + p.getPlayerNumber() + " passing to -- " + p.getAcross());
            }


            Log.d("PLAYER1", players[0].getCardsInHand().toString());
            Log.d("PLAYER2", players[1].getCardsInHand().toString());
            Log.d("PLAYER3", players[2].getCardsInHand().toString());
            Log.d("PLAYER4", players[3].getCardsInHand().toString());

//            humanPlayer.arrangeCards();
//            distributeCardsToPlayers();
//            adjustAllViews();

            miniRoundStart(miniRoundTurnNumber = 0);

//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    nextPassingRoundStart();
//
//                }
//            }, 4000);

            passAcross = false;
            passNone = true;

        }
        else if (passNone){
            inPassPhase = false;
            miniRoundStart(miniRoundTurnNumber = 0);

            passNone = false;
            passLeft = true;
        }

        inPassPhase = false;


    }



    private Card getCardAssociatedWithImage(Player humanPlayer, View v){
        for (int i = 0; i < humanPlayer.getCardsInHand().size(); i++){
            if (humanPlayer.getCardsInHand().get(i).hasThisImage((ImageButton) v)) {
//                Log.d("RETURNING", humanPlayer.getCardsInHand().get(i).getSuite());
                return humanPlayer.getCardsInHand().get(i);
            }
        }
        Log.d("RETURNING", "FAILURE :(");
        return null;
    }


    private void addPotentialCardToPass(View view){
        if (selectedToPass < 3) {
            selectedToPass++;

            ImageButton toPass = (ImageButton) view;

            tempToPass.add(getCardAssociatedWithImage(humanPlayer, toPass));


            toPass.setTranslationY(-Math.round(30 * dm.density));
//            toPass.setColorFilter(Color.RED); // TODO: MAKE THIS GLOWING ON THE OUTSIDE OR CHANGE ALPHA OR SOMETHING ???
        }
        else{
            mustPassThreeCards();
        }

        if (selectedToPass == 3){
            passPhaseActivate();
        }

    }



    public void removePotentialCardToPass(View view){

        if (selectedToPass == 3){
            passPhaseDeActivate();
        }

        selectedToPass--;
        ImageButton toRemovePass = (ImageButton) view;

        tempToPass.remove(getCardAssociatedWithImage(humanPlayer, toRemovePass));
        toRemovePass.setTranslationY(0);
//        toRemovePass.clearColorFilter();


    }




    private void passPhaseActivate(){

        passPhaseGlowActivated = true;
        passArrow.setImageResource(0);

        if (passLeft){
            passArrow.setImageResource(R.drawable.arrow_left_glow);
        }
        else if (passRight){
            passArrow.setImageResource(R.drawable.arrow_right_glow);
        }
        else if (passAcross){
            passArrow.setImageResource(R.drawable.arrow_across_glow);
        }
        else{
            passArrow.setVisibility(View.GONE);
        }

    }

    // happens when 3 cards aren't selected therefore must take away arrow glow
    private void passPhaseDeActivate(){

        passPhaseGlowActivated = false;
        passArrow.setImageResource(0);

        if (passLeft){
            passArrow.setImageResource(R.drawable.arrow_left_noglow);
        }
        else if (passRight){
            passArrow.setImageResource(R.drawable.arrow_right_noglow);
        }
        else if (passAcross){
            passArrow.setImageResource(R.drawable.arrow_across_noglow);
        }
        else{
            passArrow.setVisibility(View.GONE);
        }

    }

    private void mustPassThreeCards(){
        mustSelectThreeCardsImage.setVisibility(View.VISIBLE);

//        mustSelectThreeCardsImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mustSelectThreeCardsImage.setVisibility(View.GONE);
//            }
//        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mustSelectThreeCardsImage.setVisibility(View.GONE);
            }
        }, 1500);
    }


    @Override
    protected void onPause() {

        if (!gameOver) {
            super.onPause();
        }

        MusicControl.leavingClass();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MusicControl.inClass(this);
    }
}


// orders the cards in list of highest to lowest with just int values -- might be useful later
class cardsOnTableComaprator implements Comparator{
    @Override
    public int compare(Object lhs, Object rhs) {

//            TreeMap.Entry entryLhs = (TreeMap.Entry) lhs;
//            TreeMap.Entry entryRhs = (TreeMap.Entry) rhs;

        Card one = (Card) lhs;
        Card other = (Card) rhs;


        if (one.getSuite().equals(other.getSuite())){
            if (one.getIntValue() > other.getIntValue())
                return -1;
            else if (one.getIntValue() < other.getIntValue())
                return 1;
            else
                return 0; // should never happen omg
        }
        else if (!one.getSuite().equalsIgnoreCase(other.getSuite())){
            switch (one.getSuite()){
                case "clubs":
                    return 1;
                case "hearts":
                    return -1;
                case "diamonds":
                    if (one.getSuite().equalsIgnoreCase("clubs"))
                        return 1;
                    else
                        return -1;
                case "spades":
                    if (one.getSuite().equalsIgnoreCase("hearts"))
                        return -1;
                    else
                        return 1;
                default:
                    return 0;
            }
        }

        return one.toString().compareToIgnoreCase(other.toString());

    }


}
