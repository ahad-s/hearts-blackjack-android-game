package com.example.potato.cards;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Created by patata on 6/4/2015.
 */

public class SettingsMenu extends Activity{

    AudioManager manager;
    int suiteNow;
    SharedPreferences.Editor editor;
    ImageView suiteChanging;

    // testing with toast stuff
//    boolean makeToast = false;
//    Intent popIntent;

    DisplayMetrics display;

    // basic assignments for controlling music and making screen smaller, suite changer doesn't work current, although images and other implementations are in place
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences(MainMenu.DEFAULT_SHARED_DATABASE, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        try{
            if (getIntent().getStringExtra("orientation").equalsIgnoreCase("horiz"))
                setContentView(R.layout.settings_horiz);
            else
                setContentView(R.layout.settings);

        } catch (NullPointerException e){
            setContentView(R.layout.settings);
        }



        display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);

        double popUpPercentX = 0.9; // easy to adjust here
        double popUpPercentY = 0.5;

        getWindow().setLayout((int) (display.widthPixels * popUpPercentX), (int) (display.heightPixels * popUpPercentY));

        // allows user to change volume
        manager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVol = manager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currVol = manager.getStreamVolume(AudioManager.STREAM_MUSIC);

        // shares data across all activities


        suiteNow = sharedPreferences.getInt("current_suite", MainMenu.DEFAULT_INT_VALUE);

        final Drawable suiteOneDrawable = getResources().getDrawable(R.drawable.hearts_king_suite1);
        final Drawable suiteTwoDrawable = getResources().getDrawable(R.drawable.hearts_king_suite2);
        final Drawable suiteThreeDrawable = getResources().getDrawable(R.drawable.hearts_king_suite3);

        suiteChanging = (ImageView) findViewById(R.id.suite_color_image);


        // volume control stuff
        SeekBar volumeControl = (SeekBar) findViewById(R.id.musicVolumeSeekBar); // music seek volume bar

        volumeControl.setProgress(getCurrentMusicLevel());

        volumeControl.jumpDrawablesToCurrentState();

        volumeControl.setMax(maxVol);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                manager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0); // changes volume as user moves
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button leftTri = (Button) findViewById(R.id.left_button);
        Button rightTri = (Button) findViewById(R.id.right_button);

        switch (suiteNow){
            case 1:
                suiteChanging.setBackground(suiteOneDrawable);
                break;
            case 2:
                suiteChanging.setBackground(suiteTwoDrawable);
                break;
            case 3:
                suiteChanging.setBackground(suiteThreeDrawable);
                break;
        }




        View.OnClickListener changerRight = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( getResources().getResourceEntryName(suiteChanging.getId()).contains("suite1")){
                    suiteNow++;
                    if (suiteNow == 4)
                        suiteNow = 1;
                    editor.putInt("current_suite", suiteNow);
                }
                else{
                    suiteNow++;
                    if (suiteNow == 4)
                        suiteNow = 1;
                    editor.putInt("current_suite", suiteNow);
                }

                switch (suiteNow){
                    case 1:
                        suiteChanging.setBackground(suiteOneDrawable);
                        break;
                    case 2:
                        suiteChanging.setBackground(suiteTwoDrawable);
                        break;
                    case 3:
                        suiteChanging.setBackground(suiteThreeDrawable);
                        break;
                }
            }
        };

        View.OnClickListener changerLeft = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( getResources().getResourceEntryName(suiteChanging.getId()).contains("suite1")){
                    suiteNow--;
                    if (suiteNow == 0)
                        suiteNow = 3;
                    editor.putInt("current_suite", suiteNow);
                }
                else{
                    suiteNow--;
                    if (suiteNow == 0)
                        suiteNow = 3;
                    editor.putInt("current_suite", suiteNow);
                }

                switch (suiteNow){
                    case 1:
                        suiteChanging.setBackground(suiteOneDrawable);
                        break;
                    case 2:
                        suiteChanging.setBackground(suiteTwoDrawable);
                        break;
                    case 3:
                        suiteChanging.setBackground(suiteThreeDrawable);
                        break;
                }
            }
        };



        leftTri.setOnClickListener(changerRight);
        rightTri.setOnClickListener(changerLeft);




    }

    @Override
    protected void onStop() {
        super.onStop();
        editor.commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        editor.commit();
    }

    // to be used by other activities -- not implemented anywhere yet
    public int getCurrentMusicLevel(){
        return ((AudioManager) getSystemService(AUDIO_SERVICE)).getStreamVolume(AudioManager.STREAM_MUSIC);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MusicControl.leavingClass();
        editor.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        MusicControl.inClass(this);
    }
}
