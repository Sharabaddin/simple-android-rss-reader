package com.example.futurist.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

public class ItemInfoActivity extends AppCompatActivity {
    private static final String TAG = "ItemInfoActivity";

    String[] items = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        int positionClickChanel = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, -1);

        // For scrolling text in item.xml layout
        TextView textView = (TextView) findViewById(R.id.textViewText);
        textView.setMovementMethod(new ScrollingMovementMethod());

        Log.d(TAG, "select info item " + positionClickChanel);
    }
}
