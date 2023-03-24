package com.vijayapps.p12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioButton radio1 = findViewById(R.id.radio1);
        RadioButton radio2 = findViewById(R.id.radio2);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
//            Toast.makeText(MainActivity.this, "Button clicked", Toast.LENGTH_SHORT).show();
            String selectedRadio = " ";
            int genderSelection = (radioGroup.getCheckedRadioButtonId());
            RadioButton selectedButton = findViewById(genderSelection);
            if (radio1.isChecked()) {
                selectedRadio += "RadioButton 1";
                Toast.makeText(MainActivity.this, selectedRadio + "\t", Toast.LENGTH_SHORT).show();
            }
            if (radio2.isChecked()) {
                selectedRadio += "RadioButton 2";
                Toast.makeText(MainActivity.this, selectedRadio + "\t", Toast.LENGTH_SHORT).show();
            }
            if (genderSelection != -1) {
                selectedRadio += selectedButton.getText().toString();
                System.out.println(selectedRadio);
                Toast.makeText(MainActivity.this, selectedRadio, Toast.LENGTH_SHORT).show();
            }


//                Toast.makeText(MainActivity.this, selectedRadio, Toast.LENGTH_SHORT).show();
        });
    }
}