package com.example.bflashy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

        getSupportActionBar().hide();

        setContentView(R.layout.activity_login);

        Button loginbutton = findViewById(R.id.btn_login);

        loginbutton.setOnClickListener(view ->{
            loginUser();
        });

        ImageView gotoregister = (ImageView) findViewById(R.id.goToRegister);
        Intent intent = new Intent(this, RegisterActivity.class);
        gotoregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });


        Intent loginintent = new Intent(this, HomepageActivity.class);

    }

    private void loginUser(){
        EditText email= findViewById(R.id.et_email);
        EditText password= findViewById(R.id.et_password);
        String emailtext = email.getText().toString();
        String passwordtext = password.getText().toString();

        if(TextUtils.isEmpty(emailtext))
        {
            email.setError("Email cannot be empty");
            password.requestFocus();
        }
        else if(TextUtils.isEmpty(passwordtext)){
            password.setError("Password cannot be empty");
            password.requestFocus();
        }
        else
            {
                mAuth.signInWithEmailAndPassword(emailtext,passwordtext).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(LoginActivity.this, "User logged in successfully!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, HomepageActivity.class));
                    }
                    else
                        Toast.makeText(LoginActivity.this, "Log in Error : " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}