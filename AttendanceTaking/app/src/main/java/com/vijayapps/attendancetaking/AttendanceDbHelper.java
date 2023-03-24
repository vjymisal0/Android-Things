package com.vijayapps.attendancetaking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AttendanceDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Attendance.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AttendanceContract.AttendanceEntry.TABLE_NAME + " (" +
                    AttendanceContract.AttendanceEntry._ID + " INTEGER PRIMARY KEY," +
                    AttendanceContract.AttendanceEntry.COLUMN_NAME_STUDENT_NAME + " TEXT," +
                    AttendanceContract.AttendanceEntry.COLUMN_NAME_DATE + " INTEGER," +
                    AttendanceContract.AttendanceEntry.COLUMN_NAME_STATUS + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + AttendanceContract.AttendanceEntry.TABLE_NAME;

    public AttendanceDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public boolean insertAttendanceRecord(String studentName, long date, int status) {
        SQLiteDatabase db = getWritableDatabase();

        // Create a new ContentValues object to store the attendance record
        ContentValues values = new ContentValues();
        values.put(AttendanceContract.AttendanceEntry.COLUMN_NAME_STUDENT_NAME, studentName);
        values.put(AttendanceContract.AttendanceEntry.COLUMN_NAME_DATE, date);
        values.put(AttendanceContract.AttendanceEntry.COLUMN_NAME_STATUS, status);

        // Insert the attendance record into the database
        long result = db.insert(AttendanceContract.AttendanceEntry.TABLE_NAME, null, values);

        // Close the database connection
        db.close();

        // Return true if the record was inserted successfully
        return result != -1;
    }

    public Cursor getAttendanceRecords(long startDate, long endDate) {
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // to retrieve
        String[] projection = {
                AttendanceContract.AttendanceEntry._ID,
                AttendanceContract.AttendanceEntry.COLUMN_NAME_STUDENT_NAME,
                AttendanceContract.AttendanceEntry.COLUMN_NAME_DATE,
                AttendanceContract.AttendanceEntry.COLUMN_NAME_STATUS
        };

        // Define a selection criteria that specifies the records to retrieve
        String selection = AttendanceContract.AttendanceEntry.COLUMN_NAME_DATE +
                " BETWEEN ? AND ?";
        String[] selectionArgs = {String.valueOf(startDate), String.valueOf(endDate)};

        // Define the sort order of the retrieved records
        String sortOrder =
                AttendanceContract.AttendanceEntry.COLUMN_NAME_STUDENT_NAME + " ASC";

        // Perform the database query
        Cursor cursor = db.query(
                AttendanceContract.AttendanceEntry.TABLE_NAME,   // The table to query
                projection,                                     // The columns to retrieve
                selection,                                      // The columns for the WHERE clause
                selectionArgs,                                  // The values for the WHERE clause
                null,                                           // Don't group the rows
                null,                                           // Don't filter by row groups
                sortOrder                                       // The sort order
        );

        return cursor;
    }

    public void deleteAttendanceRecords() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(AttendanceContract.AttendanceEntry.TABLE_NAME, null, null);
        db.close();
    }
}


