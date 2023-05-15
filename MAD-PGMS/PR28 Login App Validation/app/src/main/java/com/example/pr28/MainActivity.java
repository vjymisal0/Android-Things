package com.example.pr28;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener {

    EditText username, password;
    TextView result;
    Button login;
    int u_len = 0, p_len = 0, count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        result = findViewById(R.id.result);
        login = findViewById(R.id.login);

        username.addTextChangedListener(this);
        password.addTextChangedListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (username.getText().toString().equals("sharan2208") && password.getText().toString().equals("12345678")) {
            result.setText("Login Successful!");
            result.setTextColor(Color.GREEN);
        } else {
            result.setText("Login Failed!\nRemaining attempts: " + (3 - ++count));
            result.setTextColor(Color.RED);
            if (count == 3) {
                Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (username.hasFocus())
            u_len = s.length();
        else if (password.hasFocus())
            p_len = s.length();
        login.setEnabled(u_len >= 8 && p_len >= 8);
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}