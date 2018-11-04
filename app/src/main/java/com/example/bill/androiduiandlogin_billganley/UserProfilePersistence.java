package com.example.bill.androiduiandlogin_billganley;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class UserProfilePersistence implements IPersistence{

    public DatabaseAccess databaseAccess;

    public UserProfilePersistence(Context context){
        this.databaseAccess = new DatabaseAccess(context);
    }

    @Override
    public void insert(Object o) {

        // Cast the generic object to have access to the movie info.
        UserProfile userProfile = (UserProfile) o;

        SQLiteDatabase sqLiteDatabase = databaseAccess.getWritableDatabase();

        // The ContentValues object create a map of values, where the columns are the keys
        ContentValues contentValues = new ContentValues();
        contentValues.put(UsersTable.COLUMN_NAME_FIRSTNAME, userProfile.getFirstname());
        contentValues.put(UsersTable.COLUMN_NAME_SURNAME, userProfile.getSurname());
        contentValues.put(UsersTable.COLUMN_NAME_USERNAME, userProfile.getUsername());
        contentValues.put(UsersTable.COLUMN_NAME_BIRTHDAY, userProfile.getBirthday());
        contentValues.put(UsersTable.COLUMN_NAME_MOBILE, userProfile.getMobilePhone());
        //contentValues.put(UsersTable.COLUMN_NAME_EMAIL, userProfile.getEmail());
        contentValues.put(UsersTable.COLUMN_NAME_PASSWORD, userProfile.getPassword());

        Log.d("UserProfilePersistence", "inserting user: "+userProfile.getFirstname()+" "+userProfile.getSurname());

        // Insert the ContentValues into the Users table.
        sqLiteDatabase.insert(UsersTable.TABLE_NAME, null, contentValues);

        sqLiteDatabase.close();
    }

    @Override
    public void delete(Object o) {

        UserProfile userProfile = (UserProfile) o;

        // Define which column will be the parameter for deleting the record.
        String selection = UsersTable.COLUMN_NAME_FIRSTNAME + "LIKE ? ";

        // Arguments must be identidied in the placehold order
        String [] selectionArgs = { userProfile.getFirstname().trim() };

        // Get database instance
        SQLiteDatabase sqLiteDatabase = databaseAccess.getWritableDatabase();
        sqLiteDatabase.delete(UsersTable.TABLE_NAME, selection, selectionArgs);
    }

    @Override
    public void edit(Object o) {
        // TODO for the students to practice
    }

    @Override
    public ArrayList getDataFromDB() {

        // Create ArrayList of movies
        ArrayList<UserProfile> userProfiles = null;

        // Instatiate the database.
        SQLiteDatabase sqLiteDatabase = databaseAccess.getWritableDatabase();

        // Gather all the records found for the Users table.
        Cursor cursor = sqLiteDatabase.rawQuery(UsersTable.select(), null);

        // It will iterate since the first record gathered from the database.
        cursor.moveToFirst();

        // Check if there exist other records in the cursor
        userProfiles = new ArrayList<>();

        if(cursor != null && cursor.moveToFirst()){

            do {
                String firstname = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_FIRSTNAME));
                String surname = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_SURNAME));
                String username = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_USERNAME));
                String birthday = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_BIRTHDAY));
                String mobile = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_MOBILE));
                String email = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_EMAIL));
                String password = cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME_PASSWORD));

                // Convert to UserProfile object.
                UserProfile userProfile = new UserProfile(  firstname,
                                                            surname,
                                                            username,
                                                            birthday,
                                                            mobile,
                                                            email,
                                                            password);
                userProfiles.add(userProfile);

            } while (cursor.moveToNext()) ;
        }

        return userProfiles;
    }
}
