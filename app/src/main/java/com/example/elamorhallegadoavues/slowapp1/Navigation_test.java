package com.example.elamorhallegadoavues.slowapp1;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class Navigation_test extends AppCompatActivity {
    FrameLayout frame;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //((ViewManager)frame.getParent()).removeView();
                    frame = (FrameLayout) findViewById(R.id.content);
                    frame.removeAllViewsInLayout();
                    LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_prueba_home, frame, true);
                    return true;
                case R.id.navigation_dashboard:

                    frame = (FrameLayout) findViewById(R.id.content);
                    frame.removeAllViewsInLayout();
                    LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_prueba_dashboard, frame, true);
                    return true;
                case R.id.navigation_notifications:



                    frame = (FrameLayout) findViewById(R.id.content);
                    frame.removeAllViewsInLayout();


                    LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_prueba_notificaciones, frame, true);
                    return true;
            }
            return false;
        }

    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_home, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_test);

        frame = (FrameLayout) findViewById(R.id.content);
        LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_prueba_home, frame, true);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.logout){
            new Preferences(getApplicationContext()).setPreferenceInt("texto",-1);
            Intent intento = new Intent(this, MainActivity.class);
            startActivity(intento);
        }
        return super.onOptionsItemSelected(item);
    }



}
