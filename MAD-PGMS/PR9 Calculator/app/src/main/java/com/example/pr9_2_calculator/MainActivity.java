package com.example.pr9_2_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        res = findViewById(R.id.res);
    }

    public void add(View view) {
        res.setText(String.valueOf(Double.parseDouble(num1.getText().toString()) + Double.parseDouble(num2.getText().toString())));
    }

    public void sub(View view) {
        res.setText(String.valueOf(Double.parseDouble(num1.getText().toString()) - Double.parseDouble(num2.getText().toString())));
    }

    public void mul(View view) {
        res.setText(String.valueOf(Double.parseDouble(num1.getText().toString()) * Double.parseDouble(num2.getText().toString())));
    }

    public void div(View view) {
        res.setText(String.valueOf(Double.parseDouble(num1.getText().toString()) / Double.parseDouble(num2.getText().toString())));
    }

}