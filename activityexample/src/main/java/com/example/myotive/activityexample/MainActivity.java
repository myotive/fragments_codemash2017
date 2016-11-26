package com.example.myotive.activityexample;

import android.app.ActivityGroup;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends ActivityGroup {

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = (TabHost)findViewById(R.id.tab_host);
        tabHost.setup(getLocalActivityManager());

        tabHost.addTab(tabHost.newTabSpec("one")
                .setIndicator("First Activity")
                .setContent(new Intent(this, FirstActivity.class)));

        tabHost.addTab(tabHost.newTabSpec("two")
                .setIndicator("Second Activity")
                .setContent(new Intent(this, SecondActivity.class)));

    }
}
