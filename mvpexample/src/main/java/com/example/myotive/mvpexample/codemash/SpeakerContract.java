package com.example.myotive.mvpexample.codemash;

import com.example.myotive.codemash_common.network.models.Speaker;
import com.example.myotive.mvpexample.BasePresenter;
import com.example.myotive.mvpexample.BaseView;

import java.util.List;

/**
 * Created by michaelyotive_hr on 12/17/16.
 */

public interface SpeakerContract  {
    interface View extends BaseView<Presenter>{
        void updateSpeakerList(List<Speaker> speakers);
        Speaker onSpeakerClick(int pos);
    }

    interface Presenter extends BasePresenter{
        void getSpeakerList();
    }
}
