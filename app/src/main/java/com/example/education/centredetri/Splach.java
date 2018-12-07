package com.example.education.centredetri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splach extends AppCompatActivity {

    private ImageView iv_splash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);

        iv_splash = findViewById(R.id.iv_splash);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.transition);
        iv_splash.startAnimation(anim);
        final Intent i = new Intent(this, connexion.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();

    }
}
