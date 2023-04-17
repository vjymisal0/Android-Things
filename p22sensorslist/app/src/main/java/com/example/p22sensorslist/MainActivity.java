package com.example.p22sensorslist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView sensorListTV;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorListTV = findViewById(R.id.textView);
        sensorListTV.setVisibility(View.GONE);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> list = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (int i = 1; i < list.size(); i++) {
            sensorListTV.setVisibility(View.VISIBLE);
            sensorListTV.append(list.get(i).getName() + "\n ==> " + list.get(i).getVendor() + "\n ==> " + list.get(i).getVersion());
        }
    }
}