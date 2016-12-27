package com.example.myotive.fragmentsample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myotive.codemash_common.BaseApplication;
import com.example.myotive.codemash_common.network.CodeMashAPI;
import com.example.myotive.codemash_common.network.models.Speaker;
import com.example.myotive.codemash_common.ui.RoundedTransformation;
import com.example.myotive.codemash_common.ui.SpeakerAdapter;
import com.example.myotive.codemash_common.utility.ConversionUtility;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpeakerDetailFragment extends Fragment {

    private static final String TAG = SpeakerDetailFragment.class.getSimpleName();

    private static final String SPEAKER_KEY = "SPEAKER_KEY";

    // Local Data
    private Speaker speaker;
    // UI
    private ImageView speakerImage;
    private TextView speakerBio;

    public SpeakerDetailFragment() {
        // Required empty public constructor
    }

    public static SpeakerDetailFragment newInstance(Speaker speaker) {

        SpeakerDetailFragment fragment = new SpeakerDetailFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(SPEAKER_KEY, speaker);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            speaker = (Speaker) getArguments().getSerializable(SPEAKER_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_speaker_detail, container, false);

        speakerImage = (ImageView)view.findViewById(R.id.detail_profile_image);
        if(!TextUtils.isEmpty(speaker.getGravatarUrl())){

            String gravatarUrl = speaker.getGravatarUrl();
            // As of 12/4, the gravatar URL is missing the protocol and that makes Picasso sad.
            if(!speaker.getGravatarUrl().contains("http")){
                gravatarUrl = "http:" + speaker.getGravatarUrl();
            }

            int speakerProfileSize = ConversionUtility.dpToPx(225, getContext());
            int radius = speakerProfileSize / 2;
            gravatarUrl = gravatarUrl + "?size=" + String.valueOf(speakerProfileSize);

            Picasso.with(getContext())
                    .load(gravatarUrl)
                    .transform(new RoundedTransformation(radius, 4))
                    .placeholder(com.example.myotive.codemash_common.R.drawable.codemash_gearhead)
                    .into(speakerImage);
        }
        else{
            Picasso.with(getContext())
                    .load(com.example.myotive.codemash_common.R.drawable.codemash_gearhead)
                    .into(speakerImage);
        }

        speakerBio = (TextView)view.findViewById(R.id.detail_profile_bio);
        speakerBio.setText(speaker.getBiography());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        if(((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(speaker.getFullName());
        }

    }
}
