package com.example.minehunter;
import android.content.Context;
import android.media.MediaPlayer;

public class MediaPlayerUtil {
    private MediaPlayer mediaPlayer;

    public void playSound(Context context, int resId) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }

        mediaPlayer = MediaPlayer.create(context, resId);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // Do not automatically restart, let the user decide
                stopMediaPlayer();
            }
        }); 

        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                // Restart on error
                restartMediaPlayer(context, resId);
                return true;
            }
        });

        mediaPlayer.start();
    }

    private void restartMediaPlayer(Context context, int resId) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }

        mediaPlayer = MediaPlayer.create(context, resId);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // Do not automatically restart, let the user decide
                stopMediaPlayer();
            }
        });

        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                // Restart on error
                restartMediaPlayer(context, resId);
                return true;
            }
        });

        mediaPlayer.start();
    }

    public void stopMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void release() {
        stopMediaPlayer();
    }
}
