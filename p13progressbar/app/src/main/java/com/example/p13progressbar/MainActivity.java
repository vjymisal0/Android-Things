package com.example.p13progressbar;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void download(View view) {
        ProgressDialog progressBar = new ProgressDialog(this);
        progressBar.setMessage("Downloading...");
        progressBar.setCancelable(true);
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();
        new Thread(new Runnable() {
            public void run() {
                try {
                    while (progressBar.getProgress() < progressBar.getMax()) {
                        Thread.sleep(200);
                        progressBar.incrementProgressBy(10);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
