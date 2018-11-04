package com.example.bill.androiduiandlogin_billganley;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
                        Log.d("MainActivity", "username =  " + up.getUsername());
                        Log.d("MainActivity", "password =  " + up.getPassword());
                        Log.d("MainActivity", "entered username =  " + mUserText.getText().toString());
                        Log.d("MainActivity", "entered password =  " + mPasswordText.getText().toString());
                        String enteredUser = mUserText.getText().toString();
                        String enteredPasswored = mPasswordText.getText().toString();
                        if (enteredUser.equals(up.getUsername().trim())) {
                            Log.d("MainActivity","username matched");
                            if (enteredPasswored.equals(up.getPassword())) {
                                Log.d("MainActivity","password matched");
                                Intent myIntent = new Intent(MainActivity.this, LoginSuccessActivity.class);
                                //Add USERNAME to intent for Welcome message
                                myIntent.putExtra("USERNAME", mUserText.getText().toString());
                                MainActivity.this.startActivity(myIntent);
                            }
                            else {
                                Log.d("MainActivity","password did not match "+up.getPassword());
                            }
                        }
                        else {
                            Log.d("MainActivity","username did not match "+up.getUsername());
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
