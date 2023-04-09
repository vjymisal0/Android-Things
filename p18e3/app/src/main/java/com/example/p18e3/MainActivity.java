package com.example.p18e3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText numberInput;
    Button factorialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput = findViewById(R.id.number_input);
        factorialButton = findViewById(R.id.factorial_button);

        factorialButton.setOnClickListener(v -> {
            int number = Integer.parseInt(numberInput.getText().toString());
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("number", number);
            startActivity(intent);

        });
    }

    protected void onStart() {
        super.onStart();
        Log.d("onStart()", "onStart() called");

    }

    protected void onResume() {
        super.onResume();
        Log.d("onResume()", "onResume() called");

    }

    protected void onPause() {
        super.onPause();
        Log.d("onPause()", "onPause() called");

    }

    protected void onStop() {
        super.onStop();
        Log.d("onStop()", "onStop() called");

    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy()", "onDestroy() called");

    }

    protected void onRestart() {
        super.onRestart();
        Log.d("onRestart()", "onRestart() called");

    }


}
