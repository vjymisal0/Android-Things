package com.example.asynctaskwithchat;

import android.provider.BaseColumns;

public class DBContract {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "users.db";

    private DBContract() {}

    public static class User implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_EMAIL = "email";
    }
}
