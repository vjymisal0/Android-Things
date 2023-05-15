package com.example.pr16_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showTime(View view) {
        TimePicker t1 = findViewById(R.id.t1);
        TimePicker t2 = findViewById(R.id.t2);
        Toast.makeText(this, "Time selected: " + t1.getHour() + ":" + t1.getMinute(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Time selected: " + t2.getHour() + ":" + t2.getMinute(), Toast.LENGTH_SHORT).show();
    }
}