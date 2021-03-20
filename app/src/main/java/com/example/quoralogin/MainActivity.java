package com.example.quoralogin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout Google_login, Facebook_login, Twitter_login;
    TextView Login_button, SignUp_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Google_login = findViewById(R.id.Google_login);
        Facebook_login = findViewById(R.id.Facebook_login);
        Twitter_login = findViewById(R.id.Twitter_login);
        Login_button = findViewById(R.id.Login_button);
        SignUp_button = findViewById(R.id.SignUp_button);

        Google_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NewGoogle = new Intent(MainActivity.this , SignUp_Google.class);
                startActivity(NewGoogle);
            }
        });

        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NewMain = new Intent(MainActivity.this , DashboardMenu.class);
                startActivity(NewMain);
            }
        });
    }
}