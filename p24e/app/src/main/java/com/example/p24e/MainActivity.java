package com.example.p24e;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends Activity {

    private ListView listView;
    private Set<BluetoothDevice> pairedDevices;

    BluetoothAdapter ba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(BLUETOOTH_SERVICE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ba = bluetoothManager.getAdapter();
        listView = findViewById(R.id.listView);
    }

    public void turnOn(View v) {

        if (!ba.isEnabled()) {
            Intent intentOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intentOn, 0);
            Toast.makeText(getApplicationContext(), "Turned ON", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Already ON", Toast.LENGTH_SHORT).show();
        }
    }

    public void turnOff(View v) {
        ba.disable();
        Toast.makeText(getApplicationContext(), "Turned OFF", Toast.LENGTH_SHORT).show();
    }

    public void getVisible(View v) {
        Intent intentVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(intentVisible, 0);
    }

    public void listDevices(View v) {
        pairedDevices = ba.getBondedDevices();
        ArrayList<String> list = new ArrayList<String>();

        for (BluetoothDevice b : pairedDevices) {
            list.add(b.getName());
        }
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }
}



