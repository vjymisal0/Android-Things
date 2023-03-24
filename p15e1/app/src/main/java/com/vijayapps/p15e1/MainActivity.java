package com.vijayapps.p15e1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    CheckBox pizza,coffe,burger;
    Button buttonOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pizza=(CheckBox)findViewById(R.id.checkBox);
        coffe=(CheckBox)findViewById(R.id.checkBox2);
        burger=(CheckBox)findViewById(R.id.checkBox3);
        buttonOrder=(Button)findViewById(R.id.button);

        //Applying the Listener on the Button click
        buttonOrder.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                int totalamount = 0;
                StringBuilder result = new StringBuilder();
                result.append("Selected Items:");

                if(pizza.isChecked()){
                    result.append("\nPizza 100Rs");
                    totalamount += 100;
                }

                if(coffe.isChecked()){
                    result.append("\nCoffe 50Rs");
                    totalamount += 50;
                }

                if(burger.isChecked()){
                    result.append("\nBurger 120Rs");
                    totalamount += 120;
                }

                result.append("\nTotal: "+totalamount+"Rs");
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}