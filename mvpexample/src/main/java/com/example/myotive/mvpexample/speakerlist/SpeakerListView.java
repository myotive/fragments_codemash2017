package com.example.myotive.mvpexample.speakerlist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.example.myotive.codemash_common.network.models.Speaker;
import com.example.myotive.codemash_common.ui.SpeakerAdapter;
import com.example.myotive.mvpexample.R;
import com.example.myotive.mvpexample.SpeakerDetailActivity;

import java.util.Collections;
import java.util.List;

/**
 * Created by michaelyotive_hr on 12/17/16.
 */

public class SpeakerListView extends FrameLayout implements SpeakerListContract.View {


    private RecyclerView speakerRecyclerView;
    private SpeakerAdapter speakerAdapter;

    private SpeakerListContract.Presenter presenter;

    private View.OnClickListener speakerClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            int itemPosition = speakerRecyclerView.getChildLayoutPosition(view);
            Speaker speaker = speakerAdapter.getItem(itemPosition);

            Intent intent = new Intent(getContext(), SpeakerDetailActivity.class);
            intent.putExtra("EXTRA_SPEAKER", speaker);
            getContext().startActivity(intent);
        }
    };

    public SpeakerListView(Context context) {
        super(context);
        init();
    }

    public SpeakerListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SpeakerListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_speaker_list, this);

        speakerAdapter = new SpeakerAdapter(getContext(), Collections.<Speaker>emptyList(), speakerClickListener);
        speakerRecyclerView = (RecyclerView) this.findViewById(R.id.rv_speakers);
        speakerRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        speakerRecyclerView.setAdapter(speakerAdapter);
    }

    @Override
    public void updateSpeakerList(List<Speaker> speakers) {
        speakerAdapter.swap(speakers);
    }

    @Override
    public void setPresenter(SpeakerListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
