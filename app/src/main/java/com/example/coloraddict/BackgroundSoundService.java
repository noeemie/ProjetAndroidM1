/**
 * @author Lucas Marc-Martin
 * @date 18.03.2021
 */

package com.example.coloraddict;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class BackgroundSoundService extends Service {
    MediaPlayer mediaPlayer;
    private int length = 0;
    private boolean running;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.audio);
        mediaPlayer.setLooping(true); // Set looping
        mediaPlayer.setVolume(100, 100);
    }

    /**
     * Start the background music
     */
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        Toast.makeText(getApplicationContext(), "Playing royalty-free music in the Background",    Toast.LENGTH_SHORT).show();
        running = true;
        return startId;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public void onLowMemory() {
    }

    public void pauseMusic()
    {
        if(mediaPlayer.isPlaying())
        {
            mediaPlayer.pause();
            length=mediaPlayer.getCurrentPosition();
            running = false;
        }
    }

    public void resumeMusic()
    {
        if(mediaPlayer.isPlaying()==false)
        {
            mediaPlayer.seekTo(length);
            mediaPlayer.start();
            running = true;
        }
    }

    public void pauseUnpauseMusic(){
        if(running == true){
            pauseMusic();
        }
        else{
            resumeMusic();
        }
    }
}
