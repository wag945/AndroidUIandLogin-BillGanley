package com.example.bill.androiduiandlogin_billganley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class SignupActivity extends AppCompatActivity {

    private EditText mFirstnameText;
    private EditText mSurnameText;
    private EditText mBirthdayText;
    private EditText mMobileText;
    private EditText mEmailText;
    private EditText mPasswordText;
    private Button mConfirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mFirstnameText = (EditText) findViewById(R.id.editTextFirstname);
        mSurnameText = (EditText) findViewById(R.id.editTextSurname);
        mBirthdayText = (EditText) findViewById(R.id.editTextBirthday);
        mMobileText = (EditText) findViewById(R.id.editTextMobile);
        mEmailText = (EditText) findViewById(R.id.editTextEmail);
        mPasswordText = (EditText) findViewById(R.id.editTextPassword);
        mConfirmButton = (Button) findViewById(R.id.confirmButton);

        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignupActivity.this,R.string.user_created,Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(SignupActivity.this, MainActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                SignupActivity.this.startActivity(myIntent);
            }
        });
    }
}
