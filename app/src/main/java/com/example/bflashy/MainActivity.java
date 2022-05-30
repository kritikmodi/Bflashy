package com.example.bflashy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private static int SPLASH_SCREEN_TIME_OUT=2000;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //This method is used so that your splash activity
        //can cover the entire screen.

        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_main);
        //this will bind your MainActivity.class file with activity_main.

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent is used to switch from one activity to another.
                FirebaseUser user = mAuth.getCurrentUser();
                if (user == null)
                {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
                else
                {
                    startActivity(new Intent(MainActivity.this, HomepageActivity.class));
                }
                //invoke the SecondActivity.
                finish();
                //the current activity will get finished.
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }

}
