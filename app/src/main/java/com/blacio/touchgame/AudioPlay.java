package com.blacio.touchgame;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class AudioPlay {

    public static MediaPlayer mediaPlayer;
    private static SoundPool soundPool;
    public static void playAudio(Context c,int id){
        mediaPlayer = MediaPlayer.create(c,id);
        mediaPlayer.setLooping(true);
        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        if(!mediaPlayer.isPlaying())
        {
            try {
                mediaPlayer.start();
            }catch (Exception e){}
        }
    }
    public static void stopAudio(){

        try {
            mediaPlayer.release();
            mediaPlayer = null;
        }catch (Exception e){}
    }


    public static void pauseAudio(){

        try {
            mediaPlayer.pause();
        }catch (Exception e){}


    }


    public static void resumeAudio(){

        try {
            mediaPlayer.start();
        }catch (Exception e){}

    }
}