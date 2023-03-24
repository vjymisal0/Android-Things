package com.vijayapps.p9e1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Button add, subtract, multiply, divide;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        result = findViewById(R.id.result);

        add.setOnClickListener(v -> {
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());
                    double sum = num1 + num2;
                    result.setText("Result: " + sum);
                }
        );

        subtract.setOnClickListener(v ->
                {
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());
                    double difference = num1 - num2;
                    result.setText("Result: " + difference);
                }
        );

        multiply.setOnClickListener(v -> {
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());
                    double product = num1 * num2;
                    result.setText("Result: " + product);
                }
        );
        divide.setOnClickListener(v -> {
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());
                    double quotient = num1 / num2;
                    result.setText("Result: " + quotient);
                }
        );
    }
}

