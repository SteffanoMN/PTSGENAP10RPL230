package com.example.quoralogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;

public class SignUp_Google extends AppCompatActivity {

    EditText Email;
    Button Done;
    Drawable Border;
    RelativeLayout Warning;
    TextView Forgot, Error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__google);

        Email = findViewById(R.id.EmailorPhone);
        Done = findViewById(R.id.Complete);
        Border = this.getResources().getDrawable(R.drawable.textview_border2);
        Warning = findViewById(R.id.warning);
        Warning.setVisibility(View.GONE);
        Forgot = findViewById(R.id.ForgotEmail);
        Error = findViewById(R.id.Error);

        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString();

                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

                params.addRule(RelativeLayout.BELOW, R.id.EmailorPhone);
                params.addRule(RelativeLayout.CENTER_HORIZONTAL);
                params.setMargins(0, 27, 0, 0);

                if (email.equalsIgnoreCase("admin@gmail.com")) {
                    Toast.makeText(SignUp_Google.this, "Selamat datang", Toast.LENGTH_SHORT).show();
                    Intent NewHome = new Intent(SignUp_Google.this, PasswordGoogle.class);
                    startActivity(NewHome);
                } else {
                    Toast.makeText(SignUp_Google.this, "Incorrect email", Toast.LENGTH_SHORT).show();
                    Email.setBackground(Border);
                    Warning.setVisibility(View.VISIBLE);
                    Forgot.setLayoutParams(params);
                }

            }
            });
    }
}

