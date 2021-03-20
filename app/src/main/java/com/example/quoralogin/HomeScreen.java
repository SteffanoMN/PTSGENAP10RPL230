package com.example.quoralogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {
    // Bundle : satu set mekanisme untuk mengambil nilai yang dikirimkan pada Class DashboardMenu
    Bundle extras;
    String email;
    TextView tvemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        tvemail = (TextView) findViewById(R.id.tvemail);
        extras = getIntent().getExtras();
        if (extras != null) {
            email = extras.getString("email");
            tvemail.setText(email);
        }


    }

}
