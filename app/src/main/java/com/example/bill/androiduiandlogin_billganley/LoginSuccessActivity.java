package com.example.bill.androiduiandlogin_billganley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class LoginSuccessActivity extends AppCompatActivity {

    private TextView mWelcomeText;
    private Button mViewAllUsersButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");

        mWelcomeText = (TextView) findViewById(R.id.textViewWelcome);
        mWelcomeText.setText("Welcome "+username+"!");
        mViewAllUsersButton = (Button) findViewById(R.id.viewAllUsersButton);
        mViewAllUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(LoginSuccessActivity.this, ViewAllUsersActivity.class);
                LoginSuccessActivity.this.startActivity(myIntent);
            }
        });
    }
}
