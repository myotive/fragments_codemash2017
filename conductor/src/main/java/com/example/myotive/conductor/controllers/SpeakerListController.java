package com.example.myotive.conductor.controllers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler;
import com.example.myotive.codemash_common.network.CodeMashAPI;
import com.example.myotive.codemash_common.network.models.Speaker;
import com.example.myotive.codemash_common.ui.SpeakerAdapter;
import com.example.myotive.conductor.ProgressBarProvider;
import com.example.myotive.conductor.R;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by michaelyotive_hr on 12/30/16.
 */

public class SpeakerListController extends BaseController {

    private CodeMashAPI codeMashAPI;

    private ViewGroup container;
    private RecyclerView speakerRecyclerView;
    private SpeakerAdapter speakerAdapter;

    private Call<List<Speaker>> speakerCall;

    private View.OnClickListener speakerClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int itemPosition = speakerRecyclerView.getChildLayoutPosition(view);
            Speaker speaker = speakerAdapter.getItem(itemPosition);

            SpeakerDetailController detailController = new SpeakerDetailController(speaker);

            RouterTransaction transaction
                    = RouterTransaction.with(detailController)
                    .pushChangeHandler(new HorizontalChangeHandler())
                    .popChangeHandler(new HorizontalChangeHandler());
            getRouter().pushController(transaction);
        }
    };

    // Required constructor to restore instance state
    public SpeakerListController(Bundle args){
        super(args);
    }


    // Constructor Injection allowed with Conductor as long as you have
    // default constructor
    public SpeakerListController(CodeMashAPI api){
        this.codeMashAPI = api;
    }


    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {

        View view = inflater.inflate(R.layout.controller_speaker, container, false);

        this.container = container;

        if(speakerAdapter == null) {
            speakerAdapter = new SpeakerAdapter(getActivity(),
                    Collections.<Speaker>emptyList(),
                    speakerClickListener);
        }

        speakerRecyclerView = (RecyclerView)view.findViewById(R.id.rv_speakers);
        speakerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        speakerRecyclerView.setAdapter(speakerAdapter);

        return view;
    }

    @Override
    protected void onAttach(@NonNull View view) {
        super.onAttach(view);

        setActionBarTitle(getResources().getString(R.string.app_name));
        setDisplayHomeAsUpEnabled(false);

        if(speakerAdapter.getItemCount() == 0) {
            showProgressBar();
            speakerCall = codeMashAPI.GetSpeakers();
            speakerCall.enqueue(new Callback<List<Speaker>>() {
                @Override
                public void onResponse(Call<List<Speaker>> call, Response<List<Speaker>> response) {
                    if (response.isSuccessful()) {
                        speakerAdapter.swap(response.body());
                    }

                    hideProgressBar();
                }

                @Override
                public void onFailure(Call<List<Speaker>> call, Throwable t) {
                    hideProgressBar();
                }
            });
        }
    }

    @Override
    protected void onDetach(@NonNull View view) {
        super.onDetach(view);
        if(speakerCall != null){
            speakerCall.cancel();
        }
    }
}
