package com.example.bill.androiduiandlogin_billganley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserDetailsActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        textView = (TextView) findViewById(R.id.details_text_view_title);

        Intent intent = getIntent();

        String firstname = intent.getStringExtra("FIRSTNAME");
        String surname = intent.getStringExtra("SURNAME");
        String username = intent.getStringExtra("USERNAME");

        StringBuilder builder = new StringBuilder(50);
        builder.append("User: "+firstname);
        builder.append(" ("+surname+") ");
        builder.append("Username: - "+username);
        textView.setText(builder);
    }
}
