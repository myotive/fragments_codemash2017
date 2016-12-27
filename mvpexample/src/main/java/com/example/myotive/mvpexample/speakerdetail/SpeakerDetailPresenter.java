package com.example.myotive.mvpexample.speakerdetail;

import com.example.myotive.codemash_common.network.models.Speaker;

/**
 * Created by michaelyotive_hr on 12/17/16.
 */

public class SpeakerDetailPresenter implements SpeakerDetailContract.Presenter {

    private static final String TAG = SpeakerDetailPresenter.class.getSimpleName();

    private SpeakerDetailContract.View view;


    public SpeakerDetailPresenter(SpeakerDetailContract.View view, Speaker speaker){
        this.view = view;

        this.view.setPresenter(this);
        this.view.setSpeaker(speaker);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
