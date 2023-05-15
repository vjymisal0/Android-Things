package com.example.pr8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    public AutoCompleteTextView autotextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autotextview = findViewById(R.id.auto_complete);
        String subjects[] = {"Mobile Application Development", "Web Based Application Development using PHP", "Programming with Python", "Emerging Trends in Computer and Information Technology", "Entreprenuership Development", "Managment "};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjects);
        autotextview.setThreshold(1);
        autotextview.setAdapter(adapter);
    }
}