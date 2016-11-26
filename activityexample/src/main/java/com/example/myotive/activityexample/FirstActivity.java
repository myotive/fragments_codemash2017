package com.example.myotive.activityexample;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    TextView content;
    RelativeLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        content = (TextView) findViewById(R.id.txt_content);
        container = (RelativeLayout)findViewById(R.id.activity_container);
    }

    @Override
    protected void onResume() {
        super.onResume();

        content.setText("Hello from Activity One.");
        content.setTextColor(ContextCompat.getColor(this, android.R.color.black));
        container.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_light));
    }
}
