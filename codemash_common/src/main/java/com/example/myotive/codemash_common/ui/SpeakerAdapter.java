package com.example.myotive.codemash_common.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myotive.codemash_common.R;
import com.example.myotive.codemash_common.network.models.Speaker;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by michaelyotive_hr on 12/4/16.
 */

public class SpeakerAdapter extends RecyclerView.Adapter<SpeakerAdapter.SpeakerViewHolder>{

    private List<Speaker> speakers;
    private Context context;

    public View.OnClickListener onSpeakerClickListener;

    public SpeakerAdapter(Context context, List<Speaker> speakers){
        this.context = context;
        this.speakers = speakers;
    }

    public SpeakerAdapter(Context context, List<Speaker> speakers, View.OnClickListener onClickListener){
        this.context = context;
        this.speakers = speakers;
        this.onSpeakerClickListener = onClickListener;
    }

    @Override
    public SpeakerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_speaker, null);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onSpeakerClickListener != null){
                    onSpeakerClickListener.onClick(view);
                }
            }
        };

        return new SpeakerViewHolder(view, onClickListener);
    }

    @Override
    public void onBindViewHolder(SpeakerViewHolder holder, int position) {
        Speaker speaker = speakers.get(position);

        if(!TextUtils.isEmpty(speaker.getGravatarUrl())){

            String gravatarUrl = speaker.getGravatarUrl();
            // As of 12/4, the gravatar URL is missing the protocol and that makes Picasso sad.
            if(!speaker.getGravatarUrl().contains("http")){
                gravatarUrl = "http:" + speaker.getGravatarUrl();
            }

            Picasso.with(context)
                    .load(gravatarUrl)
                    .placeholder(R.drawable.codemash_gearhead)
                    .into(holder.speakerImage);
        }
        else{
            Picasso.with(context)
                    .load(R.drawable.codemash_gearhead)
                    .into(holder.speakerImage);
        }

        holder.speakerBio.setText(speaker.getBiography());
        holder.speakerName.setText(String.format("%s %s", speaker.getFirstName(), speaker.getLastName()));
    }

    public void swap(List<Speaker> data){
        speakers = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return speakers != null ? speakers.size() : 0;
    }

    public Speaker getItem(int pos){
        return speakers.get(pos);
    }

    /***
     * View Holder class
     */
    class SpeakerViewHolder extends RecyclerView.ViewHolder {

        protected ImageView speakerImage;
        protected TextView speakerName;
        protected TextView speakerBio;

        public SpeakerViewHolder(View itemView, View.OnClickListener onClickListener) {
            super(itemView);

            itemView.setOnClickListener(onClickListener);

            speakerImage = (ImageView) itemView.findViewById(R.id.speaker_profile_image);
            speakerName = (TextView)itemView.findViewById(R.id.speaker_name);
            speakerBio = (TextView)itemView.findViewById(R.id.speaker_bio);
        }
    }
}
