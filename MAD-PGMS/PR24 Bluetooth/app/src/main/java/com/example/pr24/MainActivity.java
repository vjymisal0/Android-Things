package com.example.pr24;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.Manifest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Set<BluetoothDevice> pairedDevices;

    BluetoothAdapter ba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(BLUETOOTH_SERVICE);
        ba = bluetoothManager.getAdapter();
        listView = findViewById(R.id.listView);
    }

    public void turnOn(View v) {
        if (!ba.isEnabled()) {
            Intent intentOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED)
                return;
            startActivityForResult(intentOn, 0);
            Toast.makeText(getApplicationContext(), "Turned ON", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Already ON", Toast.LENGTH_SHORT).show();
        }
    }

    public void turnOff(View v) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED)
            return;
        ba.disable();
        Toast.makeText(getApplicationContext(), "Turned OFF", Toast.LENGTH_SHORT).show();
    }

    public void getVisible(View v) {
        Intent intentVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_ADVERTISE) != PackageManager.PERMISSION_GRANTED)
            return;
        startActivityForResult(intentVisible, 0);
    }

    public void listDevices(View v) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED)
            return;
        pairedDevices = ba.getBondedDevices();
        ArrayList<String> list = new ArrayList<>();
        for (BluetoothDevice b : pairedDevices) {
            list.add(b.getName());
        }
        listView.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, list));
    }
}