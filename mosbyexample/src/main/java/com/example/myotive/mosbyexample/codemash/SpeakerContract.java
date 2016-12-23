package com.example.myotive.mosbyexample.codemash;

import com.example.myotive.codemash_common.network.models.Speaker;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

/**
 * Created by michaelyotive_hr on 12/17/16.
 */

public interface SpeakerContract {
    interface View extends MvpView {
        void updateSpeakerList(List<Speaker> speakers);
        Speaker onSpeakerClick(int pos);
    }

    interface Presenter extends MvpPresenter<View>{
        void getSpeakerList();
    }
}
