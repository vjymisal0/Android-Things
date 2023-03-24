package com.vijayapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText n1,n2;
TextView text1;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);
        text1=findViewById((R.id.text1));
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          int sum=Integer.parseInt(n1.getText().toString())+Integer.parseInt(n2.getText().toString());
                                          text1.setText("Addition: "+sum);
                                      }
                                  }
        );

//        Toast.makeText(MainActivity.this, "Good Morning", Toast.LENGTH_SHORT).show();
    }

}