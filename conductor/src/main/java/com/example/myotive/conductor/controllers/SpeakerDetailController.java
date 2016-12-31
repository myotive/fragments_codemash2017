package com.example.myotive.conductor.controllers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myotive.codemash_common.network.models.Speaker;
import com.example.myotive.codemash_common.ui.RoundedTransformation;
import com.example.myotive.codemash_common.utility.ConversionUtility;
import com.example.myotive.conductor.R;
import com.squareup.picasso.Picasso;

/**
 * Created by michaelyotive_hr on 12/30/16.
 */

public class SpeakerDetailController extends BaseController {

    private Speaker speaker;
    private ImageView speakerImage;
    private TextView speakerBio;

    // Required constructor to restore instance state
    public SpeakerDetailController(Bundle args){
        super(args);
    }


    // Constructor Injection allowed with Conductor as long as you have
    // default constructor
    public SpeakerDetailController(Speaker speaker){
        this.speaker = speaker;
    }


    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {

        View view = inflater.inflate(R.layout.controller_speaker_detail, container, false);


        speakerImage = (ImageView)view.findViewById(R.id.detail_profile_image);
        if(!TextUtils.isEmpty(speaker.getGravatarUrl())){

            String gravatarUrl = speaker.getGravatarUrl();
            // As of 12/4, the gravatar URL is missing the protocol and that makes Picasso sad.
            if(!speaker.getGravatarUrl().contains("http")){
                gravatarUrl = "http:" + speaker.getGravatarUrl();
            }

            int speakerProfileSize = ConversionUtility.dpToPx(225, getActivity());
            int radius = speakerProfileSize / 2;
            gravatarUrl = gravatarUrl + "?size=" + String.valueOf(speakerProfileSize);

            Picasso.with(getActivity())
                    .load(gravatarUrl)
                    .transform(new RoundedTransformation(radius, 4))
                    .placeholder(com.example.myotive.codemash_common.R.drawable.codemash_gearhead)
                    .into(speakerImage);
        }
        else{
            Picasso.with(getActivity())
                    .load(com.example.myotive.codemash_common.R.drawable.codemash_gearhead)
                    .into(speakerImage);
        }

        speakerBio = (TextView)view.findViewById(R.id.detail_profile_bio);
        speakerBio.setText(speaker.getBiography());

        return view;
    }

    @Override
    protected void onAttach(@NonNull View view) {
        super.onAttach(view);
        setActionBarTitle(speaker.getFullName());
        setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean handleBack() {
        return super.handleBack();
    }
}
