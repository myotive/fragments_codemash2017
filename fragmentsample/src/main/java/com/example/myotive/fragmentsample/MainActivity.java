package com.example.myotive.fragmentsample;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.myotive.codemash_common.utility.FragmentUtility;
import com.example.myotive.codemash_common.utility.TransitionType;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private View mainContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.loading);
        mainContent = findViewById(R.id.main_content);


        if(savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_content, SpeakerFragment.newInstance())
                    .commitNow();
        }
    }

    public void showLoading(){
        progressBar.setVisibility(View.VISIBLE);
        mainContent.setVisibility(View.GONE);
    }

    public void hideLoading(){
        progressBar.setVisibility(View.GONE);
        mainContent.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(getSupportFragmentManager().getBackStackEntryCount() > 0){
            getSupportFragmentManager().popBackStack();
        }
    }
}
