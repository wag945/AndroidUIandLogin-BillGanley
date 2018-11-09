package com.example.bill.androiduiandlogin_billganley;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;


public class ViewAllUsersActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{
//    private ListView listViewUsersCategory;
//    private UserAdapter userAdapter;
    private ArrayList<UserProfile> userProfiles;
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_users);

        Log.d("ViewAllUsersActivity", "onCreate");
        UserProfilePersistence userProfilePersistence = new UserProfilePersistence(this);
        userProfiles = userProfilePersistence.getDataFromDB();

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerViewUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, userProfiles);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        //        listViewUsersCategory = (ListView) findViewById(R.id.list_view_user_category);
//
//        UserProfilePersistence userProfilePersistence = new UserProfilePersistence(this);
//        userProfiles = userProfilePersistence.getDataFromDB();
//        Toast.makeText(ViewAllUsersActivity.this,"Number of users read from DB: "+userProfiles.size(),Toast.LENGTH_SHORT).show();
//
//        userAdapter = new UserAdapter(this,
//                R.layout.custom_list_item,
//                userProfiles);
//
//        listViewUsersCategory.setAdapter(userAdapter);
//
//        listViewUsersCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                UserProfile userProfile = (UserProfile) listViewUsersCategory.getItemAtPosition(position);
//                Intent intent = new Intent(ViewAllUsersActivity.this, UserDetailsActivity.class);
//                intent.putExtra("FIRSTNAME", userProfile.getFirstname());
//                intent.putExtra("SURNAME", userProfile.getSurname());
//                intent.putExtra("USERNAME", userProfile.getUsername());
//
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
