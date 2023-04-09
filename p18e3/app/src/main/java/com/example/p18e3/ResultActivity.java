package com.example.p18e3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView factorialOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        factorialOutput = findViewById(R.id.factorial_output);

        int number = getIntent().getIntExtra("number", 0);
//        long factorial = calculateFactorial(number);
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        factorialOutput.setText("Factorial of " + number + " is " + factorial);
    }

//    private long calculateFactorial(int number) {
//        long factorial = 1;
//        for (int i = 1; i <= number; i++) {
//            factorial *= i;
//        }
//        return factorial;
//    }
}

