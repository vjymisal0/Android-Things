package com.vijayapps.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText imageUrl;
    Button setWallpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageUrl = findViewById(R.id.imageUrl);
        setWallpaper = findViewById(R.id.setWallpaper);

        setWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SetWallpaperTask().execute(imageUrl.getText().toString());
            }
        });
    }

    private class SetWallpaperTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urls) {
            String imageUrl = urls[0];
            Bitmap bitmap = null;
            try {
                InputStream inputStream = new URL(imageUrl).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setBitmap(bitmap);
                    Toast.makeText(MainActivity.this, "Wallpaper set successfully!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(MainActivity.this, "Failed to set wallpaper", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
