package com.example.pr18_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNumber = findViewById(R.id.etNumber);
    }

    public void displayFactorial(View view) {
        Intent i = new Intent(MainActivity.this, FactorialActivity.class);
        i.putExtra("number", etNumber.getText().toString());
        startActivity(i);
    }
}