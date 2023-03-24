package com.vijayapps.db_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.vijayapps.db_1.data.MyDbHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDbHandler db = new MyDbHandler(MainActivity.this);


    }
}