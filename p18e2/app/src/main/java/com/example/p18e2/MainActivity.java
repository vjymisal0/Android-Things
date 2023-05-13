package com.example.p18e2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton tb = findViewById(R.id.toggleButton);
        TextView tv = findViewById(R.id.textView);
        tb.setOnClickListener(v -> {
            if (tb.isChecked()) {
                tv.setText("ON");
                Toast.makeText(this, "ON", Toast.LENGTH_SHORT).show();
            } else {
                tv.setText("OFF");
                Toast.makeText(this, "OFF", Toast.LENGTH_SHORT).show();
            }
        });


        Button dialerButton = findViewById(R.id.b1);
        dialerButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + "9172698237"));
            startActivity(intent);

        });
    }

}
