package com.example.quoralogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;

public class PasswordGoogle extends AppCompatActivity {

    EditText Password;
    Button Done;
    Drawable Border;
    ImageView First, Second;
    RelativeLayout Forgot, Warning;
    TextView Error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__google);

        Password = findViewById(R.id.EmailorPhone);
        Done = findViewById(R.id.Complete);
        Border = this.getResources().getDrawable(R.drawable.textview_border2);
        Warning = findViewById(R.id.warning);
        Warning.setVisibility(View.GONE);
        Forgot = findViewById(R.id.ForgotEmail);
        Error = findViewById(R.id.Error);
        First = findViewById(R.id.First_picture);
        Second = findViewById(R.id.Second_picture);
        Second.setVisibility(View.GONE);

        First.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            First.setVisibility(View.GONE);
            Second.setVisibility(View.VISIBLE);
            Password.setTransformationMethod(
                    PasswordTransformationMethod.getInstance()
            );
            }

            });

        Second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                First.setVisibility(View.VISIBLE);
                Second.setVisibility(View.GONE);
                Password.setTransformationMethod(
                        HideReturnsTransformationMethod.getInstance()
                );
            }

        });

        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Password.getText().toString();

                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

                params.addRule(RelativeLayout.BELOW, R.id.EmailorPhone);
                params.addRule(RelativeLayout.CENTER_HORIZONTAL);
                params.setMargins(0, 27, 0, 0);

                if (email.equalsIgnoreCase("123456")) {
                    Toast.makeText(PasswordGoogle.this, "Sukses Login", Toast.LENGTH_SHORT).show();
                    Intent NewSignIn = new Intent(PasswordGoogle.this, HomeScreen.class);
                    NewSignIn.putExtra("email", email);
                    startActivity(NewSignIn);
                } else if (!email.equalsIgnoreCase("admin@gmail.com")) {
                    Toast.makeText(PasswordGoogle.this, "Incorrect email", Toast.LENGTH_SHORT).show();
                    Password.setBackground(Border);
                    Warning.setVisibility(View.VISIBLE);
                    Forgot.setLayoutParams(params);
                    Error.setText("enter a valid email or phone number");
                } else if (email.matches("")) {
                    Toast.makeText(PasswordGoogle.this, "You did not enter an email", Toast.LENGTH_SHORT).show();
                    Password.setBackground(Border);
                    Warning.setVisibility(View.VISIBLE);
                    Forgot.setLayoutParams(params);
                }
            }

        });
    }
}
