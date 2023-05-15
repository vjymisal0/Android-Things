package com.example.pr12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showSelected(View view) {
        RadioButton r1 = findViewById(R.id.r1);
        RadioButton r2 = findViewById(R.id.r2);
        RadioGroup rg = findViewById(R.id.radioGroup);
        RadioButton rb = findViewById(rg.getCheckedRadioButtonId());
        String msg = "";
        if(r1.isChecked())
            msg += r1.getText().toString() + " | ";
        if(r2.isChecked())
            msg += r2.getText().toString() + " | ";
        msg += rb.getText().toString();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}