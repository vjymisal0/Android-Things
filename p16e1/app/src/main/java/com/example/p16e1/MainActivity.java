package com.example.p16e1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimePicker t1 = findViewById(R.id.timePicker1);
        TimePicker t2 = findViewById(R.id.timePicker2);

        t1.setIs24HourView(true);
        t2.setIs24HourView(true);
    }
}