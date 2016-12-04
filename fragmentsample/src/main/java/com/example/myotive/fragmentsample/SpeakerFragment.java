package com.example.myotive.fragmentsample;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myotive.codemash_common.BaseApplication;
import com.example.myotive.codemash_common.network.CodeMashAPI;

public class SpeakerFragment extends Fragment {

    CodeMashAPI codeMashAPI;

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_speaker, container, false);
    }
}
