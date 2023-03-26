package com.vijayapps.p14e4;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ScrollView scrollView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vertical_scroll);

        scrollView = findViewById(R.id.scroll_view);
        textView = findViewById(R.id.text_view);

        // Enable vertical scrolling for the TextView
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
