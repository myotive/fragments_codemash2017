package com.example.myotive.mvpexample.codemash;

import android.util.Log;

import com.example.myotive.codemash_common.network.CodeMashAPI;
import com.example.myotive.codemash_common.network.models.Speaker;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by michaelyotive_hr on 12/17/16.
 */

public class SpeakerPresenter implements SpeakerContract.Presenter {

    private static final String TAG = SpeakerPresenter.class.getSimpleName();

    private CodeMashAPI codeMashAPI;
    private SpeakerContract.View view;

    private Call<List<Speaker>> speakerCall;

    public SpeakerPresenter(CodeMashAPI codeMashAPI, SpeakerContract.View view){
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
        speakerCall = codeMashAPI.GetSpeakers();

        speakerCall.enqueue(new Callback<List<Speaker>>() {
            @Override
            public void onResponse(Call<List<Speaker>> call, Response<List<Speaker>> response) {
                if(response.isSuccessful()){
                    view.updateSpeakerList(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Speaker>> call, Throwable t) {
                Log.e(TAG, "Error calling CodeMash API", t);
            }
        });
    }
}
