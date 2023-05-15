package com.example.pr11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cb[] = new CheckBox[5];
    Button order;
    String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 5; i++) {
            int resID = getResources().getIdentifier("cb" + (i + 1), "id", getPackageName());
            cb[i] = findViewById(resID);
        }

        order = findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 5; i++) {
                    if (cb[i].isChecked()) {
                        msg += cb[i].getText().toString() + " ";
                    }
                }
                if (msg.equals(""))
                    Toast.makeText(MainActivity.this, "You selected nothing!", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(MainActivity.this, "You selected " + msg, Toast.LENGTH_SHORT).show();
                    msg = "";
                }
            }
        });

    }
}