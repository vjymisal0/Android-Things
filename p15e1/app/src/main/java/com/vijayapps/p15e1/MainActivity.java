package com.vijayapps.p15e1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox pizza, coffee, burger;
    Button buttonOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pizza = (CheckBox) findViewById(R.id.checkBox);
        coffee = (CheckBox) findViewById(R.id.checkBox2);
        burger = (CheckBox) findViewById(R.id.checkBox3);
        buttonOrder = (Button) findViewById(R.id.button);

        //Applying the Listener on the Button click
        buttonOrder.setOnClickListener(v -> {
            int totalamount = 0;
            StringBuilder result = new StringBuilder();
            result.append("Selected Items:");

            if (pizza.isChecked()) {
                result.append("Pizza 100Rs");
                totalamount += 100;
            }

            if (coffee.isChecked()) {
                result.append("Coffe 50Rs");
                totalamount += 50;
            }

            if (burger.isChecked()) {
                result.append("Burger 120Rs");
                totalamount += 120;
            }

            result.append("\nTotal: " + totalamount + "Rs");
            Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();

        });
    }
}