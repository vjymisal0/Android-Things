package com.example.p26sqliteasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText name, phone;
    TextView result;
    MyDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDatabaseHelper db = new MyDatabaseHelper(this);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        result = findViewById(R.id.result);

        findViewById(R.id.btn_insert).setOnClickListener(v -> {
            db.insertContact(new Contact(name.getText().toString(), phone.getText().toString()));
            Toast.makeText(MainActivity.this, "Record Inserted Successfully!", Toast.LENGTH_SHORT).show();

        });

        findViewById(R.id.btn_update).setOnClickListener(v -> {
            db.updateContact(new Contact(name.getText().toString(), phone.getText().toString()));
            Toast.makeText(MainActivity.this, "Record Updated Successfully!", Toast.LENGTH_SHORT).show();

        });

        findViewById(R.id.btn_delete).setOnClickListener(v -> {
            db.deleteContact(name.getText().toString());
            Toast.makeText(MainActivity.this, "Record Deleted Successfully!", Toast.LENGTH_SHORT).show();

        });

        findViewById(R.id.btn_select).setOnClickListener(v -> {
            result.setText("Your Contacts:\n");
            List<Contact> contacts = db.selectContacts();
            for (Contact contact : contacts)
                result.append(contact.getId() + ". " + contact.getName() + " (" + contact.getPhone() + ")\n");

        });
    }
}
