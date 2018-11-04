package com.example.bill.androiduiandlogin_billganley;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private EditText mUserText;
    private EditText mPasswordText;
    private Button mButtonLogin;
    private Button mButtonSignup;
    private UserProfilePersistence userProfilePersistence;
    ArrayList<UserProfile> userProfiles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserText = findViewById(R.id.editTextUser);
        mPasswordText = findViewById(R.id.editTextPassword);
        mButtonLogin = findViewById(R.id.button_login);
        mButtonSignup = findViewById(R.id.button_signup);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Need to verify username and password match an existing record in DB
                userProfilePersistence = new UserProfilePersistence(MainActivity.this);
                userProfiles = userProfilePersistence.getDataFromDB();
                Toast.makeText(MainActivity.this,"userProfiles size: "+userProfiles.size(),Toast.LENGTH_SHORT).show();
                if (userProfiles.size() > 0) {
                    for (UserProfile up : userProfiles) {
                        if ((up.getUsername().equals(mUserText.getText().toString())) &&
                                up.getPassword().equals(mPasswordText.getText().toString())) {
                            Toast.makeText(MainActivity.this, "user credentials match", Toast.LENGTH_LONG).show();

                            Intent myIntent = new Intent(MainActivity.this, LoginSuccessActivity.class);
                            //Add USERNAME to intent for Welcome message
                            myIntent.putExtra("USERNAME", mUserText.getText().toString());
                            MainActivity.this.startActivity(myIntent);
                        } else {
                            Toast.makeText(MainActivity.this, "user credentials do not match", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                else {
                    Toast.makeText(MainActivity.this,"Press SIGN UP to create account",Toast.LENGTH_LONG).show();
                }
            }
        });

        mButtonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, SignupActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}
