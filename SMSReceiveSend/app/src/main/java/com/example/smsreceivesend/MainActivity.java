package com.example.smsreceivesend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = findViewById(R.id.send);
        EditText e1 = findViewById(R.id.to);
        EditText e2 = findViewById(R.id.subject);
        b1.setOnClickListener(v -> {
            String to = e1.getText().toString();
            String msg = e2.getText().toString();
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(to, null, msg, null, null);
            Toast.makeText(this, "MSG Sent Successfully!", Toast.LENGTH_SHORT).show();
        });
    }

    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Welcome to SMS Receive Send App", Toast.LENGTH_SHORT).show();
    }

    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(new SMSReceiver(), intentFilter);
    }

    protected void onStop() {
        super.onStop();
        unregisterReceiver(new SMSReceiver());
    }

}