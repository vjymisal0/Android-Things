package com.vijayapps.autocompletesearchengine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String[] SEARCH_SUGGESTIONS = {"MAD", "EDE", "MGT", "PWP", "ETI", "WBP", "CPE"};

    private AutoCompleteTextView mSearchBox;
    private Button mSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchBox = findViewById(R.id.search_box);
        mSearchButton = findViewById(R.id.search_button);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, SEARCH_SUGGESTIONS);
        
        mSearchBox.setAdapter(adapter);

        mSearchButton.setOnClickListener(v -> {
            String query = mSearchBox.getText().toString();
            Toast.makeText(MainActivity.this, "Searching for: " + query, Toast.LENGTH_SHORT).show();
        });
    }
}






