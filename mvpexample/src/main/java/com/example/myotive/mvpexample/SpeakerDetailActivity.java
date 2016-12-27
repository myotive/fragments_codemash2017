package com.example.myotive.mvpexample;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.myotive.codemash_common.network.models.Speaker;
import com.example.myotive.mvpexample.speakerdetail.SpeakerDetailPresenter;
import com.example.myotive.mvpexample.speakerdetail.SpeakerDetailView;

public class SpeakerDetailActivity extends AppCompatActivity {

    private SpeakerDetailPresenter speakerDetailPresenter;

    private Speaker speaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_detail);

        if(getIntent() != null && getIntent().hasExtra("EXTRA_SPEAKER")){
            speaker = (Speaker)getIntent().getSerializableExtra("EXTRA_SPEAKER");
        }

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        SpeakerDetailView speakerDetailView = (SpeakerDetailView) findViewById(R.id.speakerDetailView);
        speakerDetailPresenter = new SpeakerDetailPresenter(speakerDetailView, speaker);
    }

    @Override
    public void finish() {
        super.finish();

        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        speakerDetailPresenter.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        speakerDetailPresenter.stop();
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
}
