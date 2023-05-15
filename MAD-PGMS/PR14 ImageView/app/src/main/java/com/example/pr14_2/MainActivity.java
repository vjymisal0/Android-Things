package com.example.pr14_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void change_image(View view) {
        ImageView image = findViewById(R.id.imageView);
        if (image.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.img).getConstantState())
            image.setImageResource(R.drawable.img_1);
        else
            image.setImageResource(R.drawable.img);
        Toast.makeText(this, "Image Changed", Toast.LENGTH_SHORT).show();
    }
}