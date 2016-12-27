package com.example.myotive.mvpexample.speakerlist;

import com.example.myotive.codemash_common.network.models.Speaker;
import com.example.myotive.mvpexample.mvp.BasePresenter;
import com.example.myotive.mvpexample.mvp.BaseView;

import java.util.List;

/**
 * Created by michaelyotive_hr on 12/17/16.
 */

public interface SpeakerListContract {
    interface View extends BaseView<Presenter>{
        void updateSpeakerList(List<Speaker> speakers);
        void showLoading();
        void hideLoading();
    }

    interface Presenter extends BasePresenter{
        void getSpeakerList();
    }
}
