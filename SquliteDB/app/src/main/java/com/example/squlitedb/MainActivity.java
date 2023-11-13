package com.example.squlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabaseObj;
    EditText editTextID, editTextName, editMobileNo, editSearchid;
    String cid, cname, cmobile, sql_query, sid;
    Button EnterData, SearchData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EnterData = (Button) findViewById(R.id.button);
        SearchData = (Button) findViewById(R.id.button1);
        editTextID = (EditText) findViewById(R.id.editid);
        editTextName = (EditText) findViewById(R.id.editname);
        editMobileNo = (EditText) findViewById(R.id.editmobile);
        editSearchid = (EditText) findViewById(R.id.editsearchid);
        EnterData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabaseObj = openOrCreateDatabase("AndroidJSonDataBase", Context.MODE_PRIVATE, null);
                sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS AndroidJSonTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, cid VARCHAR, name VARCHAR, mobile VARCHAR);");
                cid = editTextID.getText().toString();
                cname = editTextName.getText().toString();
                cmobile = editMobileNo.getText().toString();
                sql_query = "INSERT INTO AndroidJSonTable (cid, name, mobile) VALUES('" + cid + "', '" + cname + "', '" + cmobile + "');";
                sqLiteDatabaseObj.execSQL(sql_query);
                Toast.makeText(getApplicationContext(), "Data Inserted Successfully",
                        Toast.LENGTH_LONG).show();
            }
        });

        SearchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sid = editSearchid.getText().toString();
                Cursor cursor = sqLiteDatabaseObj.rawQuery("select * from AndroidJSonTable where cid=" + sid + "", null);
                StringBuffer buffer = new StringBuffer();
                while (cursor.moveToNext()) {
                    String cid = cursor.getString(1);
                    String name = cursor.getString(2);
                    String mob = cursor.getString(3);
                    buffer.append(cid + " " + name + " " + mob + " " + "\n");
                    Toast.makeText(getApplicationContext(), buffer, Toast.LENGTH_LONG).show();

                }
            }

        });

    }
}



