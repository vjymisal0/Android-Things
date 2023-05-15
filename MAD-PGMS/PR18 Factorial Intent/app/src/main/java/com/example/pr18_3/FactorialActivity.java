package com.example.pr18_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FactorialActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);
        Bundle b = getIntent().getExtras();
        int no = Integer.parseInt(b.getString("number"));
        long f = 1;
        for (int i = no; i > 0; i--) {
            f = f * i;
        }
        tv = findViewById(R.id.tv);
        tv.append(no + " is " + f);
    }
}