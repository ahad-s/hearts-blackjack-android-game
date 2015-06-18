package com.example.potato.cards;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by Potato on 6/14/2015.
 */
// controls music throughout app, is static and responds to each content differently (well, the same, keeps it going)
public class MusicControl {

    private static MediaPlayer player;
    private static boolean keepMusicOn;

    public static void inClass(Context context) {
        // checks intent for each class when it's created and sees if music was running previously
        if (player == null) {
            player = MediaPlayer.create(context, R.raw.elevator_music);
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setLooping(true);

            try {
                player.prepare();
            } catch (IOException e) {
            } catch (IllegalStateException e) {
            }
        }

        if (!player.isPlaying()) {
            player.start();
        }

        keepMusicOn = false;
        }


    public static void keepMusicPlaying() {
        keepMusicOn = true;
    }

    public static void leavingClass(){
        if (!keepMusicOn){
            player.pause();
        }
    }
}
