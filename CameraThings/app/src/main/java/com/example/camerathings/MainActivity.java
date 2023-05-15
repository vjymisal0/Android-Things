package com.example.camerathings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i1 = findViewById(R.id.i1);
        Button b1 = findViewById(R.id.b1);
        b1.setOnClickListener(v -> {
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i, 1);
        });
    }

    public void onActivityResult(int res, int req, Intent data) {
        super.onActivityResult(res, req, data);
        if (req == 1 && res == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            i1.setImageBitmap(bitmap);
        }
    }
}