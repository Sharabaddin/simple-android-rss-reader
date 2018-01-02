package com.example.futurist.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.nio.channels.ScatteringByteChannel;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.item);

        // For scrolling text in item.xml layout
        //TextView textView = (TextView) findViewById(R.id.textViewText);
        //textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
