package com.example.p15e2customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = findViewById(R.id.button);
        b1.setOnClickListener(v -> {
            // Inflate the custom layout
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.layout_toast,
                    (ViewGroup) findViewById(R.id.custom_toast_layout));

// Set the text and icon for the custom Toast
            TextView text = layout.findViewById(R.id.custom_toast_message);
            text.setText("Hello, World!");

            ImageView icon = layout.findViewById(R.id.custom_toast_icon);
            icon.setImageResource(R.drawable.ic_launcher);

// Create and show the custom Toast
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();

        });
    }
}