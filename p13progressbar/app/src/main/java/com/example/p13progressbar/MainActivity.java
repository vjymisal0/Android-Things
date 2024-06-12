package com.example.p13progressbar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t1 = findViewById(R.id.t1);
        progressBar = findViewById(R.id.progressBar);

        // Start long running operation in a background thread
        new Thread(() -> {
            while (progressStatus < 100) {
                progressStatus++;
                // Update the progress bar in the UI thread
                handler.post(() -> {
                    progressBar.setProgress(progressStatus);
//                    t1.setText(progressStatus + "/" + progressBar.getMax());
                    t1.setText(progressStatus + "%");
                });

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
