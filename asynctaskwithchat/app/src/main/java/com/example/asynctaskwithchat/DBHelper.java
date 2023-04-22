package com.example.asynctaskwithchat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, DBContract.DATABASE_NAME, null, DBContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_USERS_TABLE = "CREATE TABLE " + DBContract.User.TABLE_NAME + " (" +
                DBContract.User._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DBContract.User.COLUMN_NAME + " TEXT NOT NULL," +
                DBContract.User.COLUMN_EMAIL + " TEXT NOT NULL" +
                ");";

        db.execSQL(SQL_CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not implemented yet
    }
}
