package com.example.basicbankingapp.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.User.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(1000,'Meet Parmar', 'meet@gmail.com','98892292', 10000000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1001,'Ronald Patrick', 'ronald@gmail.com','98892293', 900000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1002,'Bhavendra Panchal', 'bhavendra@gmail.com','98892294', 900000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1003,'Riya Parmar', 'riya@gmail.com','98892295', 900000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1004,'Prisha Sharma', 'prisha@gmail.com','98892296', 500000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1005,'Sagar Mishra', 'sagarmishra@gmail.com','98892297', 800000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1006,'Sagar Makwana', 'sagarmakwana@gmail.com','98892298', 700000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1007,'Tanay Shah', 'tanay@gmail.com','98892299', 700000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1008,'Rohan Rawat', 'rohan@gmail.com','98892282', 20000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1009,'Uttam Savaliya', 'uttam@gmail.com','98892283', 50000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1010,'Dev Prajapati', 'dev@gmail.com','98892284', 25000)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}