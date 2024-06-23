package com.vijayapps.p7e2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etAdminName, etAdminEmail, etAdminPassword;
    private Button btnRegister;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAdminName = findViewById(R.id.et_admin_name);
        etAdminEmail = findViewById(R.id.et_admin_email);
        etAdminPassword = findViewById(R.id.et_admin_password);
        btnRegister = findViewById(R.id.btn_register);

        // Initialize database
        HotelManagementDbHelper dbHelper = new HotelManagementDbHelper(this);
        db = dbHelper.getWritableDatabase();

        btnRegister.setOnClickListener(v -> registerAdmin());
    }

    private void registerAdmin() {
        String name = etAdminName.getText().toString().trim();
        String email = etAdminEmail.getText().toString().trim();
        String password = etAdminPassword.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("password", password);

        long newRowId = db.insert("admins", null, values);

        if (newRowId != -1) {
            Toast.makeText(this, "Admin registered successfully", Toast.LENGTH_SHORT).show();
            // Clear fields after successful registration
            etAdminName.setText("");
            etAdminEmail.setText("");
            etAdminPassword.setText("");
        } else {
            Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show();
        }
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}