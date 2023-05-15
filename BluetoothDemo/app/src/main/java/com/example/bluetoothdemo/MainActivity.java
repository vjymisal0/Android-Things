package com.example.bluetoothdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1, b2;
        b1 = findViewById(R.id.btnOn);
        b2 = findViewById(R.id.btnDis);
        BluetoothAdapter ba = BluetoothAdapter.getDefaultAdapter();
        b1.setOnClickListener(v -> {
            if (ba.isEnabled()) {
                Toast.makeText(getApplicationContext(), "Bluetooth is already on!", Toast.LENGTH_SHORT).show();
            } else {
                Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(i, 1);

            }
        });
        b2.setOnClickListener(v ->

        {
            Intent i1 = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            i1.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
            startActivityForResult(i1, 2);


        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(getApplicationContext(), "Bluetooth is on!", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "Bluetooth on cancelled!", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == 2 && resultCode == 300) {
            Toast.makeText(getApplicationContext(), "Bluetooth is discoverable for 300 seconds!", Toast.LENGTH_SHORT).show();
        }

    }
}
