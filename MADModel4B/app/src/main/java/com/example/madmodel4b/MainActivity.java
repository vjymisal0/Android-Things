package com.example.madmodel4b;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tvDate, tvTime;
    DatePicker dtpcker;
    TimePicker timepcker;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
        b1 = findViewById(R.id.btnDate);
        b2 = findViewById(R.id.btnTime);
        dtpcker = findViewById(R.id.dtpcker);
        timepcker = findViewById(R.id.timepcker);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvDate.setText("Date : " + dtpcker.getDayOfMonth() + "- " + dtpcker.getMonth() + "-" + dtpcker.getYear());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTime.setText(timepcker.getCurrentHour() + ":" + timepcker.getCurrentMinute());
            }
        });
    }
}