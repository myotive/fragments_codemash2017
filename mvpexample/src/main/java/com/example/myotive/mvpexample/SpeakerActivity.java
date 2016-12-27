package com.example.myotive.mvpexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myotive.codemash_common.BaseApplication;
import com.example.myotive.codemash_common.network.CodeMashAPI;
import com.example.myotive.mvpexample.speakerlist.SpeakerListPresenter;
import com.example.myotive.mvpexample.speakerlist.SpeakerListView;

public class SpeakerActivity extends AppCompatActivity {

    private SpeakerListView speakerListView;
    private SpeakerListPresenter speakerListPresenter;
    private CodeMashAPI codeMashAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_list);

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        speakerListView = (SpeakerListView)findViewById(R.id.speakerView);
        codeMashAPI = BaseApplication.getApplication(this).getApplicationComponent().CodeMashAPI();

        speakerListPresenter = new SpeakerListPresenter(codeMashAPI, speakerListView);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
        }

        speakerListPresenter.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        speakerListPresenter.stop();
    }
}
