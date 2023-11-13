package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate() method", Toast.LENGTH_SHORT).show();

    }

    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart() method ", Toast.LENGTH_SHORT).show();
    }

    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume() method ", Toast.LENGTH_SHORT).show();
    }

    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause() method ", Toast.LENGTH_SHORT).show();
    }

    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop() method ", Toast.LENGTH_SHORT).show();
    }

    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart() method ", Toast.LENGTH_SHORT).show();
    }

    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy() method ", Toast.LENGTH_SHORT).show();
    }

}