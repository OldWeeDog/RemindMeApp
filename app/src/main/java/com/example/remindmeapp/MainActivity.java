package com.example.remindmeapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {
    /*
    Initializing the required layout elements,
    set them up using the setupVariables method below
     */

    /*
    For clarity, TV = TextView, ET = EditText
     */
    private EditText username;
    private EditText password;
    private Button login;
    private TextView loginLockedTV;
    private TextView attemptsLeftTV;
    private TextView numberOfRemainingLoginAttemptsTV;
    /**
     * The Number of remaining login attempts.
     */
    int numberOfRemainingLoginAttempts = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupVariables();
    }

    /**
     * Authenticate login.
     *
     * @param view the view
     */
/*
    When the login button is pressed, authenticateLogin is called.
    If the provided credentials are correct, line 50 is executed and the user is greeted,
    but if not, the user is informed by switching the remaining attempts text view to visible,
    but if it was the third time login was attempted,
    the login button is grayed out; and another TextView is shown.
     */
    public void authenticateLogin(View view) {
        if (username.getText().toString().equals("admin") &&
                password.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "Welcome!",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Login Failed!",
                    Toast.LENGTH_SHORT).show();
            numberOfRemainingLoginAttempts--;
            attemptsLeftTV.setVisibility(View.VISIBLE);
            numberOfRemainingLoginAttemptsTV.setVisibility(View.VISIBLE);
            numberOfRemainingLoginAttemptsTV.setText(Integer.toString(numberOfRemainingLoginAttempts));

            if (numberOfRemainingLoginAttempts == 0) {
                login.setEnabled(false);
                loginLockedTV.setVisibility(View.VISIBLE);
                loginLockedTV.setBackgroundColor(Color.RED);
                loginLockedTV.setText("LOGIN LOCKED!!!");
            }
        }
    }

    private void setupVariables() {
        username = findViewById(R.id.usernameET); //(EditText)
        password = findViewById(R.id.passwordET); //(EditText)
        login = findViewById(R.id.loginBtn);  //(Button)
        loginLockedTV = findViewById(R.id.loginLockedTV);  //(TextView)
        attemptsLeftTV = findViewById(R.id.attemptsLeftTV);  //(TextView)
        numberOfRemainingLoginAttemptsTV = findViewById(R.id.numberOfRemainingLoginAttemptsTV);  //(TextView)
        numberOfRemainingLoginAttemptsTV.setText(Integer.toString(numberOfRemainingLoginAttempts));
    }

}
