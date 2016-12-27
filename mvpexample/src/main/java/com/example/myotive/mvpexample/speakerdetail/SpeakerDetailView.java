package com.example.myotive.mvpexample.speakerdetail;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.myotive.codemash_common.network.models.Speaker;
import com.example.myotive.codemash_common.ui.RoundedTransformation;
import com.example.myotive.codemash_common.utility.ConversionUtility;
import com.example.myotive.mvpexample.R;
import com.squareup.picasso.Picasso;

/**
 * Created by michaelyotive_hr on 12/17/16.
 */

public class SpeakerDetailView extends ScrollView implements SpeakerDetailContract.View {

    // UI
    private ImageView speakerImage;
    private TextView speakerBio;

    // Local Data
    private Speaker speaker;
    private SpeakerDetailContract.Presenter presenter;

    public SpeakerDetailView(Context context) {
        super(context);
        init();
    }

    public SpeakerDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SpeakerDetailView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_speaker_detail, this);

        speakerImage = (ImageView)findViewById(R.id.detail_profile_image);

        speakerBio = (TextView)findViewById(R.id.detail_profile_bio);
    }

    @Override
    public void setPresenter(SpeakerDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
        UpdateUI();
    }

    private void UpdateUI() {
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

        speakerBio.setText(speaker.getBiography());
    }
}
