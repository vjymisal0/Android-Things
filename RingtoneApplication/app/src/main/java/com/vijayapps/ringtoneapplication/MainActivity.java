package com.vijayapps.ringtoneapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText linkEditText;
    private Button setRingtoneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkEditText = findViewById(R.id.linkEditText);
        setRingtoneButton = findViewById(R.id.setRingtoneButton);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.System.canWrite(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:" + getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivityForResult(intent, 0);
            }
        }

        setRingtoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = linkEditText.getText().toString();
                setRingtone(link);
            }
        });
    }

    private void setRingtone(String link) {
        Uri uri = Uri.parse(link);
        RingtoneManager.setActualDefaultRingtoneUri(
                MainActivity.this,
                RingtoneManager.TYPE_RINGTONE,
                uri
        );
        Toast.makeText(this, "Ringtone set!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Settings.System.canWrite(this)) {
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


}

