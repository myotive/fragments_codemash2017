package com.example.myotive.activityexample;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView content;
    RelativeLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        content = (TextView)findViewById(R.id.txt_content);
        container = (RelativeLayout)findViewById(R.id.activity_container);
    }

    @Override
    protected void onResume() {
        super.onResume();

        content.setText("Hello from Activity Two.");
        content.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        container.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
    }
}
