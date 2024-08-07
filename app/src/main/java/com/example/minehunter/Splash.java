package com.example.minehunter;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    ImageView imageView;
    TextView text;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //#####################animation########################

        imageView = findViewById(R.id.splashlogo);
        text = findViewById(R.id.splashText);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in );
        imageView.setAnimation(animation);
        text.setAnimation(animation);

        //#########################################################


        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                Intent intent=new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();


            }
        },2300);



    }
}