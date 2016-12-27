package com.example.myotive.mvpexample.speakerlist;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.myotive.codemash_common.network.CodeMashAPI;
import com.example.myotive.codemash_common.network.models.Speaker;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by michaelyotive_hr on 12/17/16.
 */

public class SpeakerListPresenter implements SpeakerListContract.Presenter {

    private static final String TAG = SpeakerListPresenter.class.getSimpleName();

    private CodeMashAPI codeMashAPI;
    private SpeakerListContract.View view;

    private Call<List<Speaker>> speakerCall;

    public SpeakerListPresenter(CodeMashAPI codeMashAPI, SpeakerListContract.View view){
        this.codeMashAPI = codeMashAPI;
        this.view = view;

        this.view.setPresenter(this);
    }

    @Override
    public void start() {
        getSpeakerList();
    }

    @Override
    public void stop() {
        if( speakerCall != null ){
            speakerCall.cancel();
        }
    }

    @Override
    public void getSpeakerList() {

        view.showLoading();
        speakerCall = codeMashAPI.GetSpeakers();

        speakerCall.enqueue(new Callback<List<Speaker>>() {
            @Override
            public void onResponse(Call<List<Speaker>> call, Response<List<Speaker>> response) {
                if(response.isSuccessful()){
                    view.updateSpeakerList(response.body());
                }
                view.hideLoading();
            }

            @Override
            public void onFailure(Call<List<Speaker>> call, Throwable t) {
                Log.e(TAG, "Error calling CodeMash API", t);
                view.hideLoading();
            }
        });
    }
}
