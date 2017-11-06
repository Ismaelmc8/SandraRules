package com.example.elamorhallegadoavues.slowapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashArt extends AppCompatActivity {
    private int id_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_art);

        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();

                    id_login = new Preferences(getApplicationContext()).getPreferenceInt("texto");
                    sleep(1000);  //Delay of 10 seconds
                } catch (Exception e) {

                } finally {
                    Intent i;
                    if (id_login > 0){
                         i = new Intent(SplashArt.this,
                                Navigation_test.class);
                    }else{
                        i = new Intent(SplashArt.this,
                                MainActivity.class);
                    }

                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }
}
