package com.dhruvil.pixcel_effect.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.dhruvil.pixcel_effect.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
        findViewById(R.id.appname).setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, activity_home.class));
                finish();
            }
        }, 4000);

    }
}