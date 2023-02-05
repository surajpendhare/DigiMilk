package com.app.digimilk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {
    private static final String SHARED_PREF_NAME = "mysharedpref";
    private static final String USERNAME = "username";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String userName = sp.getString(USERNAME, null);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i;
                if(userName == null)  i = new Intent(SplashScreen.this, LoginScreen.class);
                else i = new Intent(SplashScreen.this, MainActivity.class);
//                    Toast.makeText(SplashScreen.this, "Please"+ userName, Toast.LENGTH_SHORT).show();

                startActivity(i);
                finish();
            }
        }, 5000);
    }
}