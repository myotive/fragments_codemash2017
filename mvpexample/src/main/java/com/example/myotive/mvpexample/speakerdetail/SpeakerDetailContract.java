package com.example.myotive.mvpexample.speakerdetail;

import com.example.myotive.codemash_common.network.models.Speaker;
import com.example.myotive.mvpexample.mvp.BasePresenter;
import com.example.myotive.mvpexample.mvp.BaseView;

import java.util.List;

/**
 * Created by michaelyotive_hr on 12/17/16.
 */

public interface SpeakerDetailContract {
    interface View extends BaseView<Presenter>{
        void setSpeaker(Speaker speaker);
    }

    interface Presenter extends BasePresenter{

    }
}
