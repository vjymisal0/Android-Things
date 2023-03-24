package com.vijayapps.db_1.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.vijayapps.db_1.params.params;

public class MyDbHandler extends SQLiteOpenHelper {

    public MyDbHandler(Context context) {
        super(context, params.DB_NAME, null, params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE = "CREATE TABLE " + params.TABLE_NAME + "("
                + params.KEY_ID + " INTEGER PRIMARY KEY," + params.KEY_NAME + " TEXT,"
                + params.KEY_PHONE + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
