package com.example.myotive.fragmentsample;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myotive.codemash_common.BaseApplication;
import com.example.myotive.codemash_common.network.CodeMashAPI;
import com.example.myotive.codemash_common.network.models.Speaker;
import com.example.myotive.codemash_common.ui.SpeakerAdapter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpeakerFragment extends Fragment {

    private static final String TAG = SpeakerFragment.class.getSimpleName();

    private CodeMashAPI codeMashAPI;
    private RecyclerView speakerRecyclerView;
    private SpeakerAdapter speakerAdapter;

    public SpeakerFragment() {
        // Required empty public constructor
    }

    public static SpeakerFragment newInstance() {
        return new SpeakerFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        codeMashAPI = BaseApplication.getApplication(context).getApplicationComponent().CodeMashAPI();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_speaker, container, false);

        speakerAdapter = new SpeakerAdapter(getContext(), Collections.<Speaker>emptyList());

        speakerRecyclerView = (RecyclerView)view.findViewById(R.id.rv_speakers);
        speakerRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        speakerRecyclerView.setAdapter(speakerAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        codeMashAPI.GetSpeakers().enqueue(new Callback<List<Speaker>>() {
            @Override
            public void onResponse(Call<List<Speaker>> call, Response<List<Speaker>> response) {
                if(response.isSuccessful()){
                    speakerAdapter.swap(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Speaker>> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }
}
