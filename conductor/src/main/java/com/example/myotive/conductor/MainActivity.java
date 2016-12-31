package com.example.myotive.conductor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.bluelinelabs.conductor.ChangeHandlerFrameLayout;
import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.example.myotive.codemash_common.BaseApplication;
import com.example.myotive.codemash_common.network.CodeMashAPI;
import com.example.myotive.conductor.controllers.SpeakerListController;

public class MainActivity extends AppCompatActivity implements ProgressBarProvider, ActionBarProvider {

    private FrameLayout mainContent;
    private ProgressBar progressBar;
    private Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CodeMashAPI codeMashAPI = BaseApplication.getApplication(this)
                .getApplicationComponent()
                .CodeMashAPI();

        mainContent = (FrameLayout)findViewById(R.id.main_content);
        progressBar = (ProgressBar)findViewById(R.id.loading);

        router = Conductor.attachRouter(this, mainContent, savedInstanceState);

        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(new SpeakerListController(codeMashAPI)));
        }
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
        if (!router.handleBack()) {
            super.onBackPressed();
        }
    }

    @Override
    public void showProgressBar() {
        mainContent.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mainContent.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }
}
