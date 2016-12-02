package rtc.papatsara.kanyanee.amazingsuanphueng;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import java.util.AbstractCollection;

/**
 * Created by ACER on 2/12/2559.
 */

public class SpashSceen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Sound Effect
        MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.intro_tata);
        mediaPlayer.start();

        // Auto Run
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SpashSceen.this, MainActivity.class));
                finish();
            }
        }, 9000);


    }   // Main Method

}   // Main Class










