package com.example.sqlitesimple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText id = findViewById(R.id.id);
        EditText name = findViewById(R.id.name);
        EditText mobno = findViewById(R.id.mobno);
        db = openOrCreateDatabase("CustomerDB", Context.MODE_PRIVATE, null);
        findViewById(R.id.store).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("CREATE TABLE IF NOT EXISTS CUSTOMER(id VARCHAR, name VARCHAR, mobno VARCHAR);");
                db.execSQL("INSERT INTO CUSTOMER VALUES('" + id.getText() + "','" + name.getText() + "','" + mobno.getText() + "');");
                Toast.makeText(getApplicationContext(), "Data Inserted Successfully", Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.retrieve).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c = db.rawQuery("SELECT * FROM CUSTOMER WHERE id='" + id.getText() + "'", null);
                StringBuffer buffer = new StringBuffer();
                while (c.moveToNext()) {
                    buffer.append(c.getString(1) + " | " + c.getString(2) + " | " + c.getString(3) + "\n");
                }
                Toast.makeText(getApplicationContext(), buffer, Toast.LENGTH_LONG).show();
                c.close();
            }
        });
    }
}