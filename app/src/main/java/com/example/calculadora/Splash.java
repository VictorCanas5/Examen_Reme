package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new CountDownTimer(1000, 5000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                    startActivity(new Intent(Splash.this, Menu.class));
            }
        }.start();

    }
}
