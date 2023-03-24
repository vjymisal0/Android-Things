package com.vijayapps.storagemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;


import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG_STORAGE = "STORAGE";
    private static final String TAG_RAM = "RAM";
    private static final String TAG_PROCESSOR = "PROCESSOR";

    private TextView modelTextView;
    private TextView versionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modelTextView = findViewById(R.id.model);
        versionTextView = findViewById(R.id.version);

        String model = AppUtils.getModel();
        String version = AppUtils.getVersion();

        modelTextView.setText("Model: " + model);
        versionTextView.setText("Version: " + version);

        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            String tag = null;
            switch (item.getItemId()) {
                case R.id.navigation_storage:
                    selectedFragment = new StorageFragment();
                    tag = TAG_STORAGE;
                    break;
                case R.id.navigation_ram:
                    selectedFragment = new RamFragment();
                    tag = TAG_RAM;
                    break;
                case R.id.navigation_processor:
                    selectedFragment = new ProcessorFragment();
                    tag = TAG_PROCESSOR;
                    break;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, selectedFragment, tag);
            transaction.commit();
            return true;
        });
    }
}
