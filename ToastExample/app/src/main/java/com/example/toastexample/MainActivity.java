package com.example.toastexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button toastButton = findViewById(R.id.btn);
        toastButton.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Hello World", Toast.LENGTH_SHORT).show();
        });


    }
}