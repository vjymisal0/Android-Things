package com.example.pr27;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        result = findViewById(R.id.result);
    }

    public void login(View v) {
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("12345")) {
            result.setText("Login Successful!");
        } else {
            Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
        }
    }
}