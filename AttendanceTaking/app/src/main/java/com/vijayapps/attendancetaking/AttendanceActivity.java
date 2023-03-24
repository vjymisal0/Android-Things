package com.vijayapps.attendancetaking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AttendanceActivity extends AppCompatActivity {

    private ListView studentsListView;
    private Button submitButton;
    private List<Student> studentsList;
    private AttendanceListAdapter adapter;
    private AttendanceDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        dbHelper = new AttendanceDbHelper(this);
        studentsListView = findViewById(R.id.students_list_view);
        submitButton = findViewById(R.id.submit_button);

        // Populate students list
        studentsList = new ArrayList<>();
        studentsList.add(new Student("John"));
        studentsList.add(new Student("Mary"));
        studentsList.add(new Student("Bob"));

        // Create adapter for the list view
        adapter = new AttendanceListAdapter(this, studentsList);
        studentsListView.setAdapter(adapter);

        // Handle submit button click
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save attendance records to database
                saveAttendance();
            }
        });
    }

    private void saveAttendance() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Get the current date and time
        Calendar calendar = Calendar.getInstance();
        long currentTime = calendar.getTimeInMillis();

        // Iterate through the list of students and save their attendance records to database
        for (int i = 0; i < studentsList.size(); i++) {
            Student student = studentsList.get(i);

            // Get the status of the student
            int status = adapter.getStatus(i);

            // Create a new ContentValues object to store the attendance record
            ContentValues values = new ContentValues();
            values.put(AttendanceContract.AttendanceEntry.COLUMN_NAME_STUDENT_NAME, student.getName());
            values.put(AttendanceContract.AttendanceEntry.COLUMN_NAME_DATE, currentTime);
            values.put(AttendanceContract.AttendanceEntry.COLUMN_NAME_STATUS, status);

            // Insert the attendance record into the database
            db.insert(AttendanceContract.AttendanceEntry.TABLE_NAME, null, values);
        }

        // Close the database connection
        db.close();

        // Show a toast message to indicate that the attendance has been saved
        Toast.makeText(this, "Attendance has been saved", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }
}

