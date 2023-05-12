package com.vijayapps.p7e2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, dob, city, email, contact;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        dob = findViewById(R.id.dob);
        city = findViewById(R.id.city);
        email = findViewById(R.id.email);
        contact = findViewById(R.id.contact);
        submit = findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String n = name.getText().toString();
                String d = dob.getText().toString();
                String ci = city.getText().toString();
                String e = email.getText().toString();
                String c = contact.getText().toString();

                if (n.isEmpty() || d.isEmpty() || ci.isEmpty() || e.isEmpty() || c.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter all data", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), n + "\n" + d + "\n" + ci + "\n" + e + "\n" + c, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}