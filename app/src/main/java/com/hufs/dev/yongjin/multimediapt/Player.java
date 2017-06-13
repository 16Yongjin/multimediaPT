package com.hufs.dev.yongjin.multimediapt;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by YONGJIN on 2017-06-07.
 */
public class Player {
    private static Player ourInstance = new Player();

    public static Player getInstance() {
        return ourInstance;
    }

    private Player() {
    }

    private MediaPlayer mp;

    public void play(Context ctx, int ID) {
        if(mp!=null&&mp.isPlaying()){
            mp.stop();
            mp.release();
        }
        mp = android.media.MediaPlayer.create(ctx, ID);
        mp.start();
    }

    public void stop() {
        if(mp!=null&&mp.isPlaying()){
            mp.stop();
            mp.release();
        }
    }
}
