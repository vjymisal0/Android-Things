package com.example.asynctaskwithchat;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

public class InsertDataTask extends AsyncTask<String, Void, Void> {
    private Context mContext;

    public InsertDataTask(Context context) {
        mContext = context;
    }

    @Override
    protected Void doInBackground(String... params) {
        String name = params[0];
        String email = params[1];

        // Insert data into the database
        DBHelper dbHelper = new DBHelper(mContext);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.User.COLUMN_NAME, name);
        values.put(DBContract.User.COLUMN_EMAIL, email);

        db.insert(DBContract.User.TABLE_NAME, null, values);

        return null;
    }
}
