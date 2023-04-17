package com.vijayapps.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progressStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        progressBar = (ProgressBar) findViewById(R.id.progressBar);
//        textView = (TextView) findViewById(R.id.textView);
//
//        // Start long running operation in a background thread
//        new Thread(new Runnable() {
//
//            public void run() {
//
//                while (progressStatus < 100) {
//
//                    progressStatus += 1;
//                    // Update the progress bar and display the
//                    //current value in the text view
//
//                    handler.post(new Runnable() {
//
//                        public void run() {
//
//                            progressBar.setProgress(progressStatus);
//                            textView.setText(progressStatus + "/" + progressBar.getMax());
//                        }
//                    });
//
//                    try {
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//    }
//}

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void download(View view) {
        ProgressDialog progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);
        progressBar.setMessage("File Downloading...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressBar.getProgress() < 100) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressBar.getProgress() + 10);
                        }
                    });
                }
            }
        }).start();

    }
}