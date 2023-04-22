package com.example.p27login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
    }

    public void login(View view) {

        if (etUsername.getText().toString().equals("admin") &&
                etPassword.getText().toString().equals("1234")) {
            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
        } else {
            tv.setText("");
            Toast.makeText(MainActivity.this, "Login fail.", Toast.LENGTH_SHORT).show();
        }
    }
}