package com.example.pr6_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout tableLayout = findViewById(R.id.tableLayout);
        TableRow tableRow;
        TextView textView;
        String[][] data = {
                {"Roll No.", "Name", "Branch"},
                {"1", "Sharaneshwar", "CM"},
                {"2", "Atharva", "CM"},
                {"3", "Vijay", "IT"},
                {"4", "Vaibhav", "CM"},
                {"5", "Susmit", "CM"},
                {"6", "Tushar", "IT"},
                {"7", "Aditya", "CM"},
                {"8", "Suraj", "CM"},
                {"9", "Somesh", "IT"},
                {"10", "Sumit", "CM"}
        };
        for (String[] row : data) {
            tableRow = new TableRow(this);
            for (String value : row) {
                textView = new TextView(this);
                textView.setText(value);
                textView.setTextSize(20);
                textView.setPadding(20, 20, 20, 20);
                tableRow.addView(textView);
            }
            tableLayout.addView(tableRow);
        }
    }
}