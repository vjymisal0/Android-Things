package com.example.p17e;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("onCreate() called", "onCreate() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart() called", "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume() called", "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause() called", "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop() called", "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy() called", "onDestroy() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("onRestart() called", "onRestart() called");
    }

}
