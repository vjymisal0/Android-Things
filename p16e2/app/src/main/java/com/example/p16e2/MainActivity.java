package com.example.p16e2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Button timeBtn, dateBtn;
    EditText editTime, editDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeBtn = findViewById(R.id.btn_time);
        dateBtn = findViewById(R.id.btn_date);
        editTime = findViewById(R.id.in_time);
        editDate = findViewById(R.id.in_date);
        dateBtn.setOnClickListener(v -> {
            showDate1();
        });
        timeBtn.setOnClickListener(v -> {
            showTime1();
        });
    }

    public void showDate1() {

        DatePickerDialog d = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                String showDate = date + "/" + (month + 1) + "/" + year;
                editDate.setText(showDate);
            }

        }, 23, 4, 27);
        d.show();
    }

    public void showTime1() {
        TimePickerDialog tp = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                String showTime = i + ":" + i1;
                editTime.setText(showTime);
            }
        }, 2, 44, true);
        tp.show();
    }
}