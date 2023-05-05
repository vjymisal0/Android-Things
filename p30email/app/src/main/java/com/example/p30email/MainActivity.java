package com.example.p30email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnSend;
    EditText edtSendTo, edtEmailSubject, edtEmailBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtSendTo = findViewById(R.id.edtSendTo);
        edtEmailSubject = findViewById(R.id.edtEmailSubject);
        edtEmailBody = findViewById(R.id.edtEmailBody);

        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(view -> {
            String emailId = edtSendTo.getText().toString();
            String emailSubject = edtEmailSubject.getText().toString();
            String emailBody = edtEmailBody.getText().toString();

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, emailId);
            intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
            intent.putExtra(Intent.EXTRA_TEXT, emailBody);
            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent, "Choose an Email Client:"));

        });


    }
}