package com.example.bill.androiduiandlogin_billganley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.support.annotation.NonNull;

public class SignupActivity extends AppCompatActivity {

    private EditText mFirstnameText;
    private EditText mSurnameText;
    private EditText mUserNameText;
    private EditText mBirthdayText;
    private EditText mMobileText;
    private EditText mEmailText;
    private EditText mPasswordText;
    private Button mConfirmButton;
    private UserProfilePersistence userProfilePersistence;
    private UserProfile userProfile;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mFirstnameText = (EditText) findViewById(R.id.editTextFirstname);
        mSurnameText = (EditText) findViewById(R.id.editTextSurname);
        mUserNameText = (EditText) findViewById(R.id.editTextUsername);
        mBirthdayText = (EditText) findViewById(R.id.editTextBirthday);
        mMobileText = (EditText) findViewById(R.id.editTextMobile);
        mEmailText = (EditText) findViewById(R.id.editTextEmail);
        mPasswordText = (EditText) findViewById(R.id.editTextPassword);
        mConfirmButton = (Button) findViewById(R.id.confirmButton);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmailText.getText().toString().trim();
                String password = mPasswordText.getText().toString();
                Log.d("SignupActivity","email: "+email+" password: "+password);
                createUser(email,password);
            }
        });

//        mConfirmButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                userProfilePersistence = new UserProfilePersistence(SignupActivity.this);
//
//                userProfile = new UserProfile(  mFirstnameText.getText().toString(),
//                                                mSurnameText.getText().toString(),
//                                                mUserNameText.getText().toString(),
//                                                mBirthdayText.getText().toString(),
//                                                mMobileText.getText().toString(),
//                                                mEmailText.getText().toString(),
//                                                mPasswordText.getText().toString());
//
//                Log.d("SignupActivity", "writing user: "+mFirstnameText.getText().toString()+" "+mSurnameText.getText().toString());
//
//                //Write UserProfile to DB
//                userProfilePersistence.insert(userProfile);
//
//                Toast.makeText(SignupActivity.this,R.string.user_created,Toast.LENGTH_SHORT).show();
//
//                Intent myIntent = new Intent(SignupActivity.this, MainActivity.class);
//                SignupActivity.this.startActivity(myIntent);
//            }
//        });
    }

    public void createUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("SignupActivity", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            String username = user.getEmail();
                            Intent myIntent = new Intent(SignupActivity.this,LoginSuccessActivity.class);
                            myIntent.putExtra("USERNAME", username);
                            SignupActivity.this.startActivity(myIntent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("SignupActivity", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignupActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
