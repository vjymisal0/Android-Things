package com.example.pr15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    CheckBox[] cb = new CheckBox[3];
    HashMap<String, Integer> items = new HashMap<>();
    StringBuilder msg = new StringBuilder("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items.put("Pizza", 170);
        items.put("Coffee", 120);
        items.put("Burger", 200);
    }

    public void order(View view) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            cb[i] = findViewById(getResources().getIdentifier("cb" + (i + 1), "id", getPackageName()));
            if (cb[i].isChecked()) {
                msg.append(cb[i].getText().toString()).append(" Rs. ").append(items.get(cb[i].getText().toString())).append("\n");
                sum += items.get(cb[i].getText().toString());
            }
        }
        if (msg.toString().equals(""))
            Toast.makeText(MainActivity.this, "You selected nothing!", Toast.LENGTH_SHORT).show();
        else {
            msg.append("Total: Rs. ").append(sum);
            TextView display = findViewById(R.id.display);
            display.setText(msg.toString());
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            msg.setLength(0);
        }
    }
}