package com.example.bill.androiduiandlogin_billganley;

public class UsersTable {
    /** Defining the Table Content **/
    public static final String TABLE_NAME = "users";
    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_FIRSTNAME = "firstname";
    public static final String COLUMN_NAME_SURNAME = "surname";
    public static final String COLUMN_NAME_USERNAME = "username";
    public static final String COLUMN_NAME_BIRTHDAY = "birthday";
    public static final String COLUMN_NAME_MOBILE = "mobile";
    public static final String COLUMN_NAME_EMAIL = "email";
    public static final String COLUMN_NAME_PASSWORD = "password";

    public static String create(){
        return new String ( "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME_FIRSTNAME + " TEXT," +
                COLUMN_NAME_SURNAME  + " TEXT," +
                COLUMN_NAME_USERNAME + " TEXT," +
                COLUMN_NAME_BIRTHDAY + " TEXT," +
                COLUMN_NAME_MOBILE + "TEXT," +
                COLUMN_NAME_EMAIL + "TEXT," +
                COLUMN_NAME_PASSWORD + "TEXT)");
    }

    public static String select(){
        return new String("SELECT * FROM "+TABLE_NAME);

    }

    public static final String delete(){
        return "DROP TABLE IF EXISTS " +TABLE_NAME;
    }
}
