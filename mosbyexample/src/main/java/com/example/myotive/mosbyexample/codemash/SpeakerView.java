package com.example.myotive.mosbyexample.codemash;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.example.myotive.codemash_common.BaseApplication;
import com.example.myotive.codemash_common.network.CodeMashAPI;
import com.example.myotive.codemash_common.network.models.Speaker;
import com.example.myotive.codemash_common.ui.SpeakerAdapter;
import com.example.myotive.mosbyexample.R;
import com.hannesdorfmann.mosby.mvp.layout.MvpFrameLayout;

import java.util.Collections;
import java.util.List;

/**
 * Created by michaelyotive_hr on 12/17/16.
 */

public class SpeakerView extends MvpFrameLayout<SpeakerContract.View, SpeakerContract.Presenter>
        implements SpeakerContract.View {


    private RecyclerView speakerRecyclerView;
    private SpeakerAdapter speakerAdapter;

    public SpeakerView(Context context) {
        super(context);
        init();
    }

    public SpeakerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SpeakerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public SpeakerContract.Presenter createPresenter() {

        CodeMashAPI codeMashAPI = BaseApplication.getApplication(getContext()).getApplicationComponent().CodeMashAPI();

        return new SpeakerPresenter(codeMashAPI);
    }

    private void init() {
        inflate(getContext(), R.layout.view_speaker, this);

        speakerAdapter = new SpeakerAdapter(getContext(), Collections.<Speaker>emptyList());
        speakerRecyclerView = (RecyclerView) this.findViewById(R.id.rv_speakers);
        speakerRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        speakerRecyclerView.setAdapter(speakerAdapter);


        speakerRecyclerView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                int itemPosition = speakerRecyclerView.getChildLayoutPosition(view);
                onSpeakerClick(itemPosition);
            }
        });
    }

    @Override
    public void updateSpeakerList(List<Speaker> speakers) {
        speakerAdapter.swap(speakers);
    }

    @Override
    public Speaker onSpeakerClick(int pos) {
        return speakerAdapter.getItem(pos);
    }
}
