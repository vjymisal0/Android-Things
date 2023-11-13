package com.example.smsreceivesend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Object[] sms = (Object[]) bundle.get("pdus");
            for (int i = 0; i < sms.length; i++) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);
                String phone = smsMessage.getDisplayOriginatingAddress();
                String msg = smsMessage.getDisplayMessageBody();
                Toast.makeText(context.getApplicationContext(), "Received From: " + phone + " msg: " + msg, Toast.LENGTH_LONG).show();
            }
        }
    }
}