package com.example.madqblastquestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private StringBuilder clickedNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickedNumbers = new StringBuilder();
//
//        TableLayout tableLayout = findViewById(R.id.tableLayout);
//        int rowCount = tableLayout.getChildCount();
//
//        for (int i = 0; i < rowCount; i++) {
//            View view = tableLayout.getChildAt(i);
//            if (view instanceof TableRow) {
//                TableRow row = (TableRow) view;
//                int buttonCount = row.getChildCount();
//
//                for (int j = 0; j < buttonCount; j++) {
//                    View buttonView = row.getChildAt(j);
//                    if (buttonView instanceof Button) {
//                        Button button = (Button) buttonView;
//                        button.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                String number = button.getText().toString();
//                                clickedNumbers.append(number);
//                            }
//                        });
//                    }
//                }
//            }
//        }
//
//        Button clearButton = findViewById(R.id.buttonClear);
//        clearButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                clickedNumbers.setLength(0); // Clear the clicked numbers
//            }
//        });
//
//        Button submitButton = findViewById(R.id.buttonSubmit);
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String clickedNumbersString = clickedNumbers.toString();
//                Toast.makeText(MainActivity.this, "Clicked Numbers: " + clickedNumbersString, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

        Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bClear, bSubmit;
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b0 = findViewById(R.id.button0);
        bClear = findViewById(R.id.buttonClear);
        bSubmit = findViewById(R.id.buttonSubmit);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = b1.getText().toString();
                clickedNumbers.append(number);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = b2.getText().toString();
                clickedNumbers.append(number);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = b3.getText().toString();
                clickedNumbers.append(number);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = b4.getText().toString();
                clickedNumbers.append(number);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = b5.getText().toString();
                clickedNumbers.append(number);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = b6.getText().toString();
                clickedNumbers.append(number);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = b7.getText().toString();
                clickedNumbers.append(number);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = b8.getText().toString();
                clickedNumbers.append(number);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = b9.getText().toString();
                clickedNumbers.append(number);
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = b0.getText().toString();
                clickedNumbers.append(number);
            }
        });
        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedNumbers.setLength(0); // Clear the clicked numbers
            }
        });
        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String clickedNumbersString = clickedNumbers.toString();
                Toast.makeText(MainActivity.this, "Clicked Numbers: " + clickedNumbersString, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
