package com.vijayapps.p14e3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);

        gridView = findViewById(R.id.gridview);
        gridView.setAdapter(new ButtonAdapter(this));
    }

    private class ButtonAdapter extends BaseAdapter {
        private Context mContext;

        private ButtonAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return 15;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Button button;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                button = new Button(mContext);
                button.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                button.setPadding(16, 16, 16, 16);
            } else {
                button = (Button) convertView;
            }

            button.setText("Button " + (position + 1));
            return button;
        }
    }
}