package com.vijayapps.p11e1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private Button showSelectedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        showSelectedButton = findViewById(R.id.showSelectedButton);

        showSelectedButton.setOnClickListener(v -> {
            String selectedCheckboxes = "";

            if (checkBox1.isChecked()) {
                selectedCheckboxes += checkBox1.getText().toString() + "\n";
            }

            if (checkBox2.isChecked()) {
                selectedCheckboxes += checkBox2.getText().toString() + "\n";
            }

            if (checkBox3.isChecked()) {
                selectedCheckboxes += checkBox3.getText().toString() + "\n";
            }

            if (checkBox4.isChecked()) {
                selectedCheckboxes += checkBox4.getText().toString() + "\n";
            }

            if (checkBox5.isChecked()) {
                selectedCheckboxes += checkBox5.getText().toString() + "\n";
            }

            if (selectedCheckboxes.isEmpty()) {
                selectedCheckboxes = "No checkboxes selected";
            }

            Toast.makeText(MainActivity.this, selectedCheckboxes, Toast.LENGTH_SHORT).show();
        });
    }
}
