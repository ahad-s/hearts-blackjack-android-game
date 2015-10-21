package com.example.potato.cards.Blackjack;

import com.example.potato.cards.Card_Engine.*;
import com.example.potato.cards.*;


import android.app.Activity;
import android.app.Instrumentation;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Potato on 6/7/2015.
 */
public class BJControl extends Activity {

    // TODO: FIX MEMORY LEAK FROM RECURSIVE PHASEFOUR()


    // TODO NEXT TIME:::
    // -ADD 3D FLIP TO FACE DOWN CARD
    // -FIX FIRST TIME CASH FAILS (SOMETIMES GET EXTRA MONEY NEAR FIRST FEW ROUNDS)
    // -ALIGN THE CARDS WITH A SLIGHT CURVE AND MAKE THEM SMALLER

    /*
    Phase 1: Betting phase -- can only control how much to bet then starts next phase after pressing "DEAL"
    Phase 2: Check phase -- your cards displayed + 1 of dealer card displayed, can "Hit" or "Stand" or "Surrender" or "Double" (double = doubles bet amount + adds new card)
    Phase 3: Hit phase -- get 1 extra card, back to Phase 2 if results <21, otherwise "lose" if results >21
    Phase 4: Stand phase -- dealer reveals + draws more if != 17 or <21 -- human cannot play at this point, just watch and win/lose -- SPECIAL RULE: DEALER MUST STOP AT 17 IF HE HITS IT
    Win: Money added to bank, back to Phase 1
    Lose: Money goes away, back to Phase 1
     */

    // RULE::: DEALER MUST STOP AT ANY VALUE FROM 17-21 TO ALLOW TO 'FAIR DEALING'

    private final int DEFAULT_END_DURATION_MS = 5000;


    private static final String TAG = BJControl.class.getSimpleName();

    Instrumentation blackjackInstrument;



    // variables and stuff, mostly references to Views to be used throughout program
    private HashMap<ImageButton, TextView> chipsMap;
    private ViewGroup outerChips;

    private Button hitButton;
    private Button standButton;
    private Button dealButton;
    private ImageButton clearButton;
    private TextView onTableTextView;
    private TextView totalMoney;
    private TextView dealerHandScoreText;
    private TextView playerHandScoreText;
    private ImageView totalMoneyImageView;
    private ImageView onTableImageView;
    private ImageView mustWagerDisplay;
    private ImageView youWon;
    private ImageView youLose;
    private ImageView youTie;

    private Display display;
    private DisplayMetrics dm;
    private ViewGroup bjGameRelativeLayout;
    private ViewGroup bjChipsLinearLayout;
    private ViewGroup playerCardLayout;
    private ViewGroup dealerCardLayout;
    private ViewGroup currentScoreLayout;
    private ViewGroup leftLayoutPhaseOne;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor prefEditor;
    private int currentMoney;
    private int currentSuite;
    private boolean flipped;
    private boolean resetAlready;

    Animation pushDownIn;
    Animation pushUpIn;
    Animation pushRightIn;
    Animation pushLeftIn;


    private Deck gameDeck;
    private PlayerBlackjack currentPlayer;

    private ArrayList<Card> currentDealerCards = new ArrayList<>();
    private Card dealerHiddenCard;
    private int dealerScore = 0; // NO NEED TO CREATE DEALER OBJECT SINCE THIS IS THE ONLY VALUE BEING USED BY DEALER
    private Drawable hiddenDrawable;

    private LinearLayout.LayoutParams bjChipsLayoutParams;
    private LinearLayout.LayoutParams bjGameRelativeParamsOriginal;

    private int originalTotalMoney;

    boolean once = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.blackjackgame);

//        activityIntent = getIntent();


        // get local app data
        sharedPreferences = getSharedPreferences(MainMenu.DEFAULT_SHARED_DATABASE, MODE_PRIVATE);
        prefEditor = sharedPreferences.edit();
        currentMoney = sharedPreferences.getInt("current_money", MainMenu.DEFAULT_STARTING_MONEY);
        currentSuite = sharedPreferences.getInt("current_suite", MainMenu.DEFAULT_INT_VALUE);

        originalTotalMoney = currentMoney;

        // mostly stuff for phase 2
        currentPlayer = new PlayerBlackjack(currentMoney);

        leftLayoutPhaseOne = (ViewGroup) findViewById(R.id.left_layout_for_phase_one);
        dealerCardLayout = (ViewGroup) findViewById(R.id.dealer_cardspace_layout);
        playerCardLayout = (ViewGroup) findViewById(R.id.player_cardspace_layout);
        currentScoreLayout = (ViewGroup) findViewById(R.id.current_score_text);
        bjChipsLinearLayout = (ViewGroup) findViewById(R.id.bjchipsgrid);
        bjGameRelativeLayout = (ViewGroup) findViewById(R.id.bjgamelayout);

        // this is done so animations come in properly
        playerCardLayout.setClipChildren(false);
        dealerCardLayout.setClipChildren(false);

        dealerHandScoreText = (TextView) findViewById(R.id.dealer_handscore_text);
        playerHandScoreText = (TextView) findViewById(R.id.player_handscore_text);

        // set all views to be used by stuff throughout class
        hitButton = (Button) findViewById(R.id.hit_button);
        standButton = (Button) findViewById(R.id.stand_button);
        dealButton = (Button) findViewById(R.id.deal_button);
        onTableTextView = (TextView) findViewById(R.id.money_on_table_textview);
        onTableImageView = (ImageView) findViewById(R.id.money_counter_dealphase_imageview);
        totalMoneyImageView = (ImageView) findViewById(R.id.money_counter_imageview);
        totalMoney = (TextView) findViewById(R.id.money_counter_textview);
        mustWagerDisplay = (ImageView) findViewById(R.id.must_wager_money);
        clearButton = (ImageButton) findViewById(R.id.blackjack_clear_button);
        youWon = (ImageView) findViewById(R.id.you_win_view);
        youLose = (ImageView) findViewById(R.id.you_lose_view);
        youTie = (ImageView) findViewById(R.id.you_tie_view);

        pushDownIn = AnimationUtils.loadAnimation(this, R.anim.push_down_in);
        pushUpIn = AnimationUtils.loadAnimation(this, R.anim.push_up_in);
        pushRightIn = AnimationUtils.loadAnimation(this, R.anim.push_right_in);
        pushLeftIn = AnimationUtils.loadAnimation(this, R.anim.push_left_in);

        // sets total money initially
        totalMoney.setText("$" + currentMoney);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCounterListeners(chipsMap);
                onTableTextView.setText("$0");
                totalMoney.setText("$" + sharedPreferences.getInt("current_money", MainMenu.DEFAULT_INT_VALUE));
            }
        });


        dealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getTextValue(onTableTextView) <= 0) {
//                    needMoneyOnTableWarning(3); // show for 3 seconds
                } else if (getTextValue(onTableTextView) > 0)
                    phaseTwo();

            }
        });

        // used to get height of screen etc.
        display = getWindowManager().getDefaultDisplay();
        dm = new DisplayMetrics();
        display.getMetrics(dm);


        chipsMap = new HashMap();
        outerChips = (ViewGroup) findViewById(R.id.bjchipsgrid);

        String[] cardFiles = new String[0];

        if (currentSuite == 1)
            cardFiles = getResources().getStringArray(R.array.suite_1_cards);
        else if (currentSuite == 2)
            cardFiles = getResources().getStringArray(R.array.suite_2_cards);
        else if (currentSuite == 3)
            cardFiles = getResources().getStringArray(R.array.suite_3_cards);

        gameDeck = new Deck(this.getApplicationContext(), "blackjack", cardFiles, currentSuite);



        // only lets app go through when it's far enough in the life cycle that the relativelayout for the cards is fully built
        // TODO: THIS "onGlobalLayout()" OCCURS WHENEVER THIS LAYOUT BECOMES VISIBLE AGAIN, SO OPTIMIZE THIS SO IT ACTUALLY DOESN'T NEED TO BE USED ONCE AND IT CAN BE REUSED PROPERLY
        bjGameRelativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (once) {
                    once = false;

                    bjGameRelativeParamsOriginal = new LinearLayout.LayoutParams(bjGameRelativeLayout.getLayoutParams());
                    bjGameRelativeParamsOriginal.weight = .5f;
                    bjGameRelativeParamsOriginal.width = 0;

                    bjChipsLayoutParams = new LinearLayout.LayoutParams(bjChipsLinearLayout.getLayoutParams());
                    bjChipsLayoutParams.weight = .25f;
                    bjChipsLayoutParams.width = 0;

                    // prepare for phase one
                    populateMap(outerChips, chipsMap);

                    setCounterListeners(chipsMap);

                    phaseOne(outerChips, chipsMap);
                }
            }
        });
    }



    private void centerMoneyAndDealButton(){

        // deal = 50dp lower from bottom

        float midY = dm.heightPixels / dm.density / 2;
        float midX = dm.widthPixels / dm.density / 2;

        onTableImageView.setX(midX);
        onTableImageView.setY(midY);

        dealButton.setX(midX);
        dealButton.setY(midY + (50 * dm.density));

    }

    // shows warning for secDuration, default == 3s
    private void needMoneyOnTableWarning(long secDuration){
        long msDuration = secDuration * 1000;

        mustWagerDisplay.setVisibility(View.VISIBLE);

        mustWagerDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mustWagerDisplay.setVisibility(View.GONE);
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mustWagerDisplay.setVisibility(View.GONE);
            }
        }, msDuration);

    }

    // instead of having to get text value with "$" signs etc, this method does it
    private static int getTextValue(TextView text){
        String val = text.getText().subSequence(1, text.length()).toString();

        int intVal = 0;

        try{
            intVal = Integer.parseInt(val);
        } catch (NumberFormatException e){
            Log.d("BJControl", e.getMessage());
        }

        return intVal;
    }

    // phase 1 -- show chips and deal when at least 1 chip is selected
    private void phaseOne(ViewGroup outerChips, HashMap<ImageButton, TextView> chipsMap){

        // sets stuff for other phases, this is done here so we don't have to do it in every outcome each time(win, lose, tie)
        resetScoreViews();
        gameDeck.resetCards();
        gameDeck.shuffle();
        gameDeck.resetCardImages();

        currentDealerCards.clear();
        currentPlayer.currentCards.clear();

        // need to do this b/c face down card doesn't get caught in resetCardImages();
        try{
            dealerCardLayout.removeAllViews();
        } catch (Exception e) {}

        dealerCardLayout.setVisibility(View.GONE);
        playerCardLayout.setVisibility(View.GONE);
        dealerHandScoreText.setVisibility(View.GONE);
        playerHandScoreText.setVisibility(View.GONE);

        resetCounterListeners(chipsMap);

        currentPlayer.setCurrentHandScore(0);
        dealerScore = 0;

        dealButton.setVisibility(View.VISIBLE);
        hitButton.setVisibility(View.GONE);
        standButton.setVisibility(View.GONE);

        bjChipsLinearLayout.setVisibility(View.VISIBLE);

        bjChipsLinearLayout.setLayoutParams(bjChipsLayoutParams);

        bjGameRelativeLayout.setVisibility(View.VISIBLE);
        bjGameRelativeLayout.setLayoutParams(bjGameRelativeParamsOriginal);


//        setChipsRelativeLayout();

//        RelativeLayout.LayoutParams dealButtonParams = new RelativeLayout.LayoutParams(dealButton.getLayoutParams());
        RelativeLayout.LayoutParams moneyCounterImageParams = new RelativeLayout.LayoutParams(onTableImageView.getLayoutParams());
        RelativeLayout.LayoutParams moneyCounterTextParams = new RelativeLayout.LayoutParams(onTableTextView.getLayoutParams());

//        dealButtonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        moneyCounterImageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        moneyCounterImageParams.addRule(RelativeLayout.CENTER_VERTICAL);

        moneyCounterTextParams.addRule(RelativeLayout.ALIGN_BOTTOM, onTableImageView.getId());
        moneyCounterTextParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        moneyCounterTextParams.setMargins(0, 0, 0, Math.round(25 * dm.density));

        onTableTextView.setLayoutParams(moneyCounterTextParams);
        onTableImageView.setLayoutParams(moneyCounterImageParams);


        try {
            bjGameRelativeLayout.removeView(totalMoneyImageView);
            bjGameRelativeLayout.removeView(totalMoney);
        } catch (Exception e) {
            Log.d("EXPECTED EXCEPTION", "Should only happen first time BJ starts in a session");
        }

        if (leftLayoutPhaseOne.getChildCount() < 1) {
            leftLayoutPhaseOne.addView(totalMoneyImageView);
            leftLayoutPhaseOne.addView(totalMoney);
        }

        flipped = false;

    }


    private void phaseTwo(){

        // NEED TO MOVE THE TOTAL MONEY COUNTER TO THE MAIN RELATIVELAYOUT
        leftLayoutPhaseOne.removeView(totalMoneyImageView);
        leftLayoutPhaseOne.removeView(totalMoney);

        bjGameRelativeLayout.addView(totalMoneyImageView);
        bjGameRelativeLayout.addView(totalMoney);

        RelativeLayout.LayoutParams totalMoneyImageParams = new RelativeLayout.LayoutParams(totalMoneyImageView.getLayoutParams());
        RelativeLayout.LayoutParams totalMoneyTextParams = new RelativeLayout.LayoutParams(totalMoney.getLayoutParams());

//        totalMoneyImageParams.leftMargin = Math.round(6 * dm.density);


        // change UI dynamically instead of creating new activity
        hitButton.setVisibility(View.VISIBLE);
        standButton.setVisibility(View.VISIBLE);
        playerHandScoreText.setVisibility(View.VISIBLE);
        dealerHandScoreText.setVisibility(View.VISIBLE);

        dealButton.setVisibility(View.GONE);

        // remove chips layout
//        bjChipsLinearLayout = (ViewGroup) findViewById(R.id.bjchipsgrid);
        bjChipsLinearLayout.setVisibility(View.GONE);

        bjGameRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

        RelativeLayout.LayoutParams moneyCounterTextParams = new RelativeLayout.LayoutParams(onTableTextView.getLayoutParams());
        RelativeLayout.LayoutParams moneyCounterImageParams = new RelativeLayout.LayoutParams(onTableImageView.getLayoutParams());

        moneyCounterImageParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        moneyCounterImageParams.addRule(RelativeLayout.CENTER_VERTICAL);
        moneyCounterImageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        moneyCounterTextParams.addRule(RelativeLayout.ALIGN_BOTTOM, onTableImageView.getId());
        moneyCounterTextParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        moneyCounterTextParams.setMargins(0, 0, 0, Math.round(25 * dm.density));

        onTableTextView.setLayoutParams(moneyCounterTextParams);
        onTableImageView.setLayoutParams(moneyCounterImageParams);

        // THESE VALUES ARENT NEEDED SINCE BLESSED ANDROID WEIGHT
            /*
            CARD PROPERTIES (approx to 4 decimal places):
            w = 958px
            h = 1300px
            w:h = 0.4243:0.5757 == 1:1.3568 == 0.737:1
            */
        // assume h = y-val = 1280px = 640dp
        // top+bot margins must add up to 385dp
        // 127.5dp = each layout's height
//        int playerLayoutHeight = playerCardLayout.getHeight();
//        int newCardMaxWidth = Math.round(playerLayoutHeight * (float) 0.737); // should be 188px for both == 94px for each == 47dp for each


        playerCardLayout.setVisibility(View.VISIBLE);
        dealerCardLayout.setVisibility(View.VISIBLE);
        currentScoreLayout.setVisibility(View.VISIBLE);



        // intially add two cards for each -- 2 face up for player, 1 face up 1 face down for dealer
        addNewCard("player");
        addNewCard("player");

        addNewCard("dealer");
        addFaceDownCard();

        hitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phaseThree();
            }
        });

        standButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phaseFour();
            }
        });



    }

    // adds new card object
    private void addFaceDownCard(){ // only used for dealer so no parameters needed
        dealerHiddenCard = gameDeck.getTopCard();
        ImageButton tempCardImage = new ImageButton(this); // MAKE NEW IMAGE SHOWING THE BACK OF A CARD
        tempCardImage.setBackground(getResources().getDrawable(R.drawable.red_card_back));

        LinearLayout.LayoutParams tempParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        tempParams.weight = (float) 1.0;

        String drawableName = dealerHiddenCard.getSuite() + "_" + dealerHiddenCard.getStringValue() + "_suite" + gameDeck.getCurrentSuite();
        hiddenDrawable = getResources().getDrawable(getResources().getIdentifier(drawableName, "drawable", getPackageName()));

        tempCardImage.setLayoutParams(tempParams);

        dealerCardLayout.addView(tempCardImage);

        dealerScore += dealerHiddenCard.getIntValue();

        currentDealerCards.add(dealerHiddenCard);

        tempCardImage.startAnimation(pushLeftIn);



//        dealerHandScoreText.setText(getResources().getString(R.string.dealer) + dealerScore); // don't set this new value since user can't know what dealer's second card is

    }

    // adds new card to currentcards list and updates score on screen
    private void addNewCard(String layoutPlayerOrDealer){
        Card tempCard = gameDeck.getTopCard();
        ImageButton tempCardImage = tempCard.getImage(); // gets image button, but no need to add onclicklistener for blackjack

        LinearLayout.LayoutParams tempParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        tempParams.weight = (float) 1.0;

        tempCardImage.setLayoutParams(tempParams);

        int heightCardLayout = Math.round(((dm.heightPixels / dm.density) - 385) / 2 * dm.density);  // 385 = margins added together, /2 because that gives height of both layouts
        tempCardImage.setMaxWidth(Math.round((float) (heightCardLayout * 0.737)));

        // name = suite_stringvalue_suite(intval)
        String drawableName = tempCard.getSuite() + "_" + tempCard.getStringValue() + "_suite" + gameDeck.getCurrentSuite();
        tempCardImage.setBackground(getResources().getDrawable(getResources().getIdentifier(drawableName, "drawable", getPackageName()))); // this way we don't have to add 52 card images on screen at once


        if (layoutPlayerOrDealer.equalsIgnoreCase("player")) {

            playerCardLayout.addView(tempCardImage);
            currentPlayer.addCard(tempCard);
            playerHandScoreText.setText("Player: " + currentPlayer.getCurrentHandScore());
            tempCardImage.startAnimation(pushLeftIn);
//            playerHandScoreText.setText(getResources().getString(R.string.player) + currentPlayer.getCurrentHandScore());

        } else if (layoutPlayerOrDealer.equalsIgnoreCase("dealer")) {

            dealerCardLayout.addView(tempCardImage);
            dealerScore += tempCard.getIntValue();
            dealerHandScoreText.setText("Dealer: " + dealerScore);
//            dealerHandScoreText.setText(getResources().getString(R.string.dealer) + dealerScore);
            currentDealerCards.add(tempCard);
            tempCardImage.startAnimation(pushLeftIn);


        }

        if (currentPlayer.getCurrentHandScore() == 21){
            winGameImage();
        }





    }


    // resets score views..
    private void resetScoreViews(){
        playerHandScoreText.setText("Player: " + "0");
        dealerHandScoreText.setText("Dealer: " + "0");
//        playerHandScoreText.setText(R.string.player + "0");
//        dealerHandScoreText.setText(R.string.dealer + "0");
    }


    // the next three methods are just different images that are shown for a few seconds upon win/loss/tie, can be clicked to return faster

    private int newTotalMoney;

    private void loseGameImage(){

        // update the views + total money
        newTotalMoney = sharedPreferences.getInt("current_money", MainMenu.DEFAULT_INT_VALUE) - getTextValue(onTableTextView);
        prefEditor.putInt("current_money", newTotalMoney);
        prefEditor.commit();

        onTableTextView.setText("$0");
        totalMoney.setText("$" + newTotalMoney);

        resetAlready = false;

        currentPlayer.setCurrentHandScore(0);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                youLose.setVisibility(View.VISIBLE);
            }
        }, 2000);

        youLose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youLose.setVisibility(View.GONE);
                phaseOne(outerChips, chipsMap);
                resetScoreViews();
                onTableTextView.setText("$0");
                totalMoney.setText("$" + newTotalMoney);

                // do this as last resort if all else fails
//                finish();
//                startActivity(activityIntent);

                resetAlready = true;
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!resetAlready) {
                    youLose.setVisibility(View.GONE);
                    phaseOne(outerChips, chipsMap);
                    resetScoreViews();
                    onTableTextView.setText("$0");
                    totalMoney.setText("$" + newTotalMoney);

//                    finish();
//                    startActivity(activityIntent);

                }
            }
        }, DEFAULT_END_DURATION_MS);
    }


    // tie == return money to owners -- NEVERMINE - DON'T INCLUDE THIS, CHANGE OF RULES -- MIGHT CHANGE MY MIND LATER
    private void tieGameImage(){

        totalMoney.setText("$" + getTextValue(totalMoney));
        onTableTextView.setText("$0");

        currentPlayer.setCurrentHandScore(0);

        resetAlready = false;


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                youTie.setVisibility(View.VISIBLE);
            }
        }, 2000);

        youTie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTie.setVisibility(View.GONE);
                phaseOne(outerChips, chipsMap);
                resetScoreViews();
                totalMoney.setText("$" + sharedPreferences.getInt("current_money", MainMenu.DEFAULT_INT_VALUE));
                onTableTextView.setText("$0");
                resetAlready = true;
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!resetAlready) {
                    youTie.setVisibility(View.GONE);
                    phaseOne(outerChips, chipsMap);
                    totalMoney.setText("$" + sharedPreferences.getInt("current_money", MainMenu.DEFAULT_INT_VALUE));
                    onTableTextView.setText("$0");
                    resetScoreViews();
                }
            }
        }, DEFAULT_END_DURATION_MS);

    }


    private void winGameImage(){

         resetAlready = false;

        // update the views + total money
        newTotalMoney = sharedPreferences.getInt("current_money", MainMenu.DEFAULT_INT_VALUE) + getTextValue(onTableTextView);
        prefEditor.putInt("current_money", newTotalMoney);
        prefEditor.commit();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                youWon.setVisibility(View.VISIBLE);
            }
        }, 2000);

        youWon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youWon.setVisibility(View.GONE);
                phaseOne(outerChips, chipsMap);
                resetScoreViews();
                onTableTextView.setText("$0");
                totalMoney.setText("$" + newTotalMoney);
//                finish();
//                startActivity(activityIntent);
                resetAlready = true;

            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!resetAlready) {
                    youWon.setVisibility(View.GONE);
                    phaseOne(outerChips, chipsMap);
                    resetScoreViews();
                    onTableTextView.setText("$0");
                    totalMoney.setText("$" + newTotalMoney);
//                    finish();
//                    startActivity(activityIntent);
                }
            }
        }, DEFAULT_END_DURATION_MS);

    }

    // hit button pressed
    private void phaseThree(){



        // TODO: Make background darker

        if (currentPlayer.getCurrentHandScore() < 21){
            addNewCard("player");
        }

        if (currentPlayer.getCurrentHandScore() == 21) {
            if (!flipped)
                turnOverFaceDown();
            winGameImage();
        }
        else if (currentPlayer.getCurrentHandScore() > 21){
            if (!flipped)
                turnOverFaceDown();
            loseGameImage();
        }




    }


    // flips around the dealer card by actually replacing it with a replica ImageView since its just for viewing purposes
    private void turnOverFaceDown(){

        dealerHandScoreText.setText("Dealer: " + dealerScore);

        String facedownSuite = dealerHiddenCard.getSuite();
        String facedownStringVal = dealerHiddenCard.getStringValue();
        int facedownSuiteNum = gameDeck.getCurrentSuite();

        ImageButton tempCardImage = new ImageButton(this);


        LinearLayout.LayoutParams tempParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        tempParams.weight = (float) 1.0;

        tempCardImage.setLayoutParams(tempParams);

        int heightCardLayout = Math.round(((dm.heightPixels / dm.density) - 385) / 2 * dm.density);  // 385 = margins added together, /2 because that gives height of both layouts
        tempCardImage.setMaxWidth(Math.round((float) (heightCardLayout * 0.737)));


        String drawableName = facedownSuite + "_" + facedownStringVal + "_suite" + facedownSuiteNum;
        Drawable tempCardDrawable = getResources().getDrawable(getResources().getIdentifier(drawableName, "drawable", getPackageName()));

        TransitionDrawable turntUp = new TransitionDrawable(new Drawable[]{hiddenDrawable, tempCardDrawable});

        tempCardImage.setBackground(turntUp); // this way we don't have to add 52 card images on screen at once

        dealerHiddenCard.setImage(tempCardImage);


//        Card tempDealerCard = new Card(facedownSuite, facedownStringVal, "blackjack", tempCardImage);

//        currentDealerCards.remove(dealerHiddenCard);
//        currentDealerCards.add(tempDealerCard);

        // cleaner to just remove all views  and add them back with face up card
        dealerCardLayout.removeAllViews();

        int tempSize = currentDealerCards.size();
        for (int i = 0; i < tempSize; i++) {
            dealerCardLayout.addView(currentDealerCards.get(i).getImage());
            if (i == 1)
                turntUp.startTransition(1000);
        }

        flipped = true;
    }

    // stand button pressed
    private void phaseFour(){

        if (!flipped)
            turnOverFaceDown();

        if (dealerScore < 17 && dealerScore < currentPlayer.getCurrentHandScore())
            addNewCard("dealer");

        if (dealerScore < 17 && dealerScore > currentPlayer.getCurrentHandScore())
            loseGameImage();


        if (dealerScore > 21){
            winGameImage();
        }

        else if (dealerScore >= 17 && dealerScore < 21){
            if (dealerScore > currentPlayer.getCurrentHandScore())
                loseGameImage();

            if (dealerScore < currentPlayer.getCurrentHandScore())
                winGameImage();

            if (dealerScore == currentPlayer.getCurrentHandScore())
                tieGameImage();
        }
        else if (dealerScore == 21 || (dealerScore > currentPlayer.getCurrentHandScore())){
            loseGameImage();
        }
        else if (dealerScore < 17){
            phaseFour();
        }
        else if (currentPlayer.getCurrentHandScore() == dealerScore){
            tieGameImage();
        }
        else
            phaseFour();
    }




    // NO NEED FOR THIS AFTER USING LAYOUT_WEIGHT FOR LINEARLAYOUT, MIGHT NEED IF SWITCH BACK TO RELATIVELAYOUT
    // prepares screens for phase one by splitting the layouts up into specific widths
    private void setChipsRelativeLayout(){
        // get screen and layouts sizes in dp (density independent pixels)

        // convert pixels (device) to dp, calculate new width, then convert back to density, taking into account margins - WOO I DIDN'T HARDCODE STUFF!
        int dpWidthChips = Math.round(91); // predefined/hardcoded in XML as dp
        int dpWidthDevice = Math.round(dm.widthPixels / dm.density);

//        int marginDimensions = (int) getResources().getDimension(R.dimen.activity_horizontal_margin);
//        int newWidth = Math.round((dpWidthDevice - dpWidthChips) * dm.density) - Math.round(marginDimensions / dm.density); // 16dp = MARGIN CONSIDERED -- should be "554p" == "277dp"

        int newWidth = Math.round((dpWidthDevice - dpWidthChips) * dm.density); // MARGIN NOT CONSIDERED -- should be "586p" == "293dp"


        // this is done so chips stay at right side of screen
        bjGameRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(newWidth, LinearLayout.LayoutParams.MATCH_PARENT)); // this needs to be Linear since parent is, even though this child is Relative
    }


    // associates the chips with their respective counters to be manipulated easily
    private void populateMap(ViewGroup outerChips, HashMap<ImageButton, TextView> chipsMap){
        // assigns imagebutton key with its respective textview counter
         for (int i = 2; i < outerChips.getChildCount(); i++) { // i = 2 because need to skip the settings and clear buttons
            try {
                ViewGroup tempGroup = (ViewGroup) outerChips.getChildAt(i);
                chipsMap.put((ImageButton) tempGroup.getChildAt(1), (TextView) tempGroup.getChildAt(0));

            } catch (ClassCastException e) { // shouldn't occur
                Log.d(TAG, "CAST EXCEPTION -- " + e.getMessage());
            } catch (Exception e) {
                Log.d(TAG, "RANDOM EXCEPTION -- " + e.getMessage());
            }
        }
    }

    // resets all the counters to 0 and clears the money on the "table"
    private void resetCounterListeners(HashMap<ImageButton, TextView> chipsMap){
        for (ImageButton key: chipsMap.keySet()){
            final TextView tempView = chipsMap.get(key);
            tempView.setText("x0");
        }
    }

    // sorts money from the string value given and adds it to both money counters
    private boolean addMoneyFromChips(String imageName){

        String[] split = imageName.split("_");
        String stringValue = split[0];
        int intValue = 0;

        switch (stringValue){
//            case "stack":
//                intValue = 1000;
//                break;
            case "fivehunna":
                intValue = 500;
                break;
            case "hunna":
                intValue = 100;
                break;
            case "fifty":
                intValue = 50;
                break;
            case "twentyfive":
                intValue = 25;
                break;
            case "ten":
                intValue = 10;
                break;
            case "five":
                intValue = 5;
                break;
        }

        // updates total money + current deal money

        if (getTextValue(totalMoney) >= intValue){

//            prefEditor.commit();

            int updatedDealMoney = getTextValue(onTableTextView) + intValue;
            int updatedTotalMoney = getTextValue(totalMoney) - intValue;

            onTableTextView.setText("$" + updatedDealMoney);
            totalMoney.setText("$" + updatedTotalMoney);
            prefEditor.putInt("current_money", updatedTotalMoney);

            return true;
        }

        return false;

    }
    // sets onclicklistener for each pair of imagebutton:textview associated
    private void setCounterListeners(HashMap<ImageButton, TextView> chipsMap) {
        for (final ImageButton key : chipsMap.keySet()) {
            final TextView temp = chipsMap.get(key); // final needed to be able to access from anonymous class
            key.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean canUpdate = addMoneyFromChips(getResources().getResourceEntryName(key.getId())); // if have enough money
                    if (canUpdate)
                        temp.setText("x" + (getTextValue(temp) + 1));
                }
            });
        }
    }

    // needed for music
    @Override
    protected void onPause() {
        super.onPause();
        MusicControl.leavingClass();


    }

    @Override
    protected void onResume() {
        super.onResume();
        MusicControl.inClass(this);
    }


}
