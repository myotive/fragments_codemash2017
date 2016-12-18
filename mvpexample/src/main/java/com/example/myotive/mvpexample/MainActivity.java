package com.example.myotive.mvpexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myotive.codemash_common.BaseApplication;
import com.example.myotive.codemash_common.network.CodeMashAPI;
import com.example.myotive.mvpexample.codemash.SpeakerPresenter;
import com.example.myotive.mvpexample.codemash.SpeakerView;

public class MainActivity extends AppCompatActivity {

    private SpeakerView speakerView;
    private SpeakerPresenter speakerPresenter;
    private CodeMashAPI codeMashAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        speakerView = (SpeakerView)findViewById(R.id.speakerView);
        codeMashAPI = BaseApplication.getApplication(this).getApplicationComponent().CodeMashAPI();

        speakerPresenter = new SpeakerPresenter(codeMashAPI, speakerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        speakerPresenter.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        speakerPresenter.stop();
    }
}
