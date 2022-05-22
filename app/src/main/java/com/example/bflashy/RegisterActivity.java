package com.example.bflashy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_register);

        ImageView gotologin = (ImageView) findViewById(R.id.goToLogin);
        Intent intent = new Intent(this, LoginActivity.class);
        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        Button registerbutton = (Button) findViewById(R.id.btn_register);
        Intent registerintent = new Intent(this, HomepageActivity.class);
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(registerintent);
            }
        });

    }
}