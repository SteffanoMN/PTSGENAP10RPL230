package com.example.quoralogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;

public class DashboardMenu extends AppCompatActivity {

    EditText Username, Email, Password;
    TextView Cancel_button, Done_button, txtCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_menu);

        Username = findViewById(R.id.Username);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        Cancel_button = findViewById(R.id.Cancel_button);
        Done_button = findViewById(R.id.Complete);
        txtCounter = findViewById(R.id.txtCounter);
        txtCounter.setVisibility(View.GONE);

        Done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();

                if (email.equalsIgnoreCase("admin@gmail.com") && password.equalsIgnoreCase
                        ("123456") && username.equalsIgnoreCase
                        ("adminname")) {
                    Toast.makeText(DashboardMenu.this, "Sukses Login", Toast.LENGTH_SHORT).show();
                    Intent NewHome = new Intent(DashboardMenu.this , HomeScreen.class);
                    NewHome.putExtra("email" , email);
                    startActivity(NewHome);
                }
                else {
                    Toast.makeText(DashboardMenu.this, "Gagal Login", Toast.LENGTH_SHORT).show();
                    txtCounter.setVisibility(View.VISIBLE);}
    }
        });

        Cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CancelAction = new Intent(DashboardMenu.this , MainActivity.class);
                startActivity(CancelAction);
            }

            });
}
}