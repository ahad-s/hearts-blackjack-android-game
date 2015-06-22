package com.example.potato.cards;

/*
Name: Ahad Shoaib
Notes:
-AI is quite basic at the moment :( inspired by Windows' heart's AI since I used to play it a bunch before
-If you run out of money in blackjack, must exit + restart game to gain more money -- there is no prompt for this
-transitioning between turns in hearts isn't that smooth at the moment, and have to respect the rules since there aren't too many 'safety' measures in place currently
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends Activity {

    // bj = blackjack
    // h = hearts

    // MUSIC: www.bensound.com - elevator music


    // some default strings to be used by all classes, mostly for sharedpreferences
    final public static int DEFAULT_INT_VALUE = 0;
    final public static String DEFAULT_STRING_VALUE = "";
    final public static String DEFAULT_SHARED_DATABASE = "database";
    final public static int DEFAULT_STARTING_MONEY = 1000;

    private Button playButton;
    private Button instructionsButton;
    private Button settingsButton;
    private ImageButton bjImageButton;
    private ImageButton hImageButton;
    private Button requestMoneyButton;

    MediaPlayer player; // need to be able to control this from settings
    int totalMoney;
    int suite = 1;
    int maxSuite = 3; // change this depending on how many suites are available
    int tempMoney;
    SharedPreferences.Editor editor;
    SharedPreferences userSharedPref;

    private boolean clickHearts = false;
    private boolean clickBlackjack = true; // is selected by default since its single player only + first option

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // initializes the XML and displays it to main screen


        // SHARED PREFERENCES STUFF, STORES VALUES ACROSS DEVICE AND ACROSS SAVES
        userSharedPref = getSharedPreferences(DEFAULT_SHARED_DATABASE, Context.MODE_PRIVATE);
        editor = userSharedPref.edit();

        if (!userSharedPref.contains("current_suite")){
            editor.putInt("current_suite", 1);
            editor.commit();
        }

        tempMoney = userSharedPref.getInt("current_money", DEFAULT_STARTING_MONEY);

        Log.d("TEMPMONEY IS..." , "@@@@ " + tempMoney);
        Log.d("SHOULD BE TRUE...", "#### " + (tempMoney == DEFAULT_INT_VALUE));

        if (tempMoney <= DEFAULT_INT_VALUE){
            editor.putInt("current_money", 500);
            editor.commit();
        }


        MusicControl.keepMusicPlaying();



        // settings listeners and stuff to navigate to other activities
        requestMoneyButton = (Button) findViewById(R.id.request_money_button);
        playButton = (Button) findViewById(R.id.play_button);
        settingsButton = (Button) findViewById(R.id.settings_button);

        hImageButton = (ImageButton) findViewById(R.id.hearts_menu);
        bjImageButton = (ImageButton) findViewById(R.id.blackjack_menu);

        bjImageButton.setColorFilter(Color.argb(125, 0, 0, 0)); // set this as originally selected game

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickHearts)
                    startActivity(new Intent(MainActivity.this, HControl.class));
                else if (clickBlackjack)
                    startActivity(new Intent(MainActivity.this, BJControl.class));
            }
        });


        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsMenu.class));
            }
        });

        requestMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempMoney = userSharedPref.getInt("current_money", DEFAULT_INT_VALUE);
                if (tempMoney <= DEFAULT_INT_VALUE){
                    editor.putInt("current_money", 500);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "$500 has been added for you to play with!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Hey! Stop being greedy! Wait until you're cleaned!", Toast.LENGTH_LONG).show();

                }
            }
        });

        hImageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setClickHearts();
            }
        });

        bjImageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setClickBlackjack();
            }
        });

        // TODO: LINK THESE TO BEGINNING OF HEARTS INTERFACE ETC.
        bjImageButton.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                // start Blackjack game code here on long press
                return false;
            }
        });

        hImageButton.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                // start Hearts game code here on long press
                return false; // makes sure that onClickListener works properly
            }

        });



        instructionsButton = (Button) findViewById(R.id.instructions_button); // R.id.* returns reference as hex value

        instructionsButton.setOnClickListener(new View.OnClickListener() { // temp popup, need to replace java with XML
            @Override
            public void onClick(View v) {
                if (clickHearts) {
                    Uri ytHowToBlackjack = Uri.parse("https://www.youtube.com/watch?v=tQJGbbk3WUs");
                    Intent howToBJ = new Intent(Intent.ACTION_VIEW, ytHowToBlackjack);
                    startActivity(howToBJ);
//                    startActivity(new Intent(MainActivity.this, BJInstructions.class )); // starts a new activity, must always use Intent
                }
                else if (clickBlackjack){
                    Uri ytHowToHearts = Uri.parse("https://www.youtube.com/watch?v=pa_sl2-629U");
                    Intent howToH = new Intent(Intent.ACTION_VIEW, ytHowToHearts);
                    startActivity(howToH);
//                    startActivity(new Intent(MainActivity.this, HInstructions.class));
                }

            }
        });

    }


    // music will persist in any app that has these two commands

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

    // selects the respective game image
    private void setClickHearts(){
        clickHearts = true;
        clickBlackjack = false;
        bjImageButton.setColorFilter(Color.argb(0, 0, 0, 0));
        hImageButton.setColorFilter(Color.argb(125, 0, 0, 0));
    }

    private void setClickBlackjack(){
        clickHearts = false;
        clickBlackjack = true;
        bjImageButton.setColorFilter(Color.argb(125, 0, 0, 0));
        hImageButton.setColorFilter(Color.argb(0, 0, 0, 0));
    }


}
