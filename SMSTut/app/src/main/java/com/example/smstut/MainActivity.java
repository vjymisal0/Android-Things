package com.example.smstut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(v -> {
            SmsManager smgr = SmsManager.getDefault();
            smgr.sendTextMessage("9172698237", null, "Hello this is sms tutorial", null, null);
        });
    }
}