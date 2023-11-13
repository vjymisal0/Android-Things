package com.example.progressbarqb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv1 = findViewById(R.id.tv);
        ProgressBar pb1 = findViewById(R.id.pb);
        int progressStatus = 0;
        Button b1 = findViewById(R.id.b1);
        b1.setOnClickListener(v -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (progressStatus < 100) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                pb1.setProgress(progressStatus);
                                tv1.setText(progressStatus + "/" + pb1.getMax());
                            }
                        });
                        try {
                            // Sleep for 200 milliseconds.
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();
        });
    }
}