package com.example.myotive.mvpexample;

import android.support.test.filters.SmallTest;

import com.example.myotive.codemash_common.network.CodeMashAPI;
import com.example.myotive.codemash_common.network.models.Speaker;
import com.example.myotive.mvpexample.speakerlist.SpeakerListContract;
import com.example.myotive.mvpexample.speakerlist.SpeakerListPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by michaelyotive_hr on 1/3/17.
 */
@SmallTest
public class SpeakerListPresenterTest {

    @Mock
    private SpeakerListContract.View view;

    @Mock
    private CodeMashAPI codeMashAPI;

    @Mock
    private Call<List<Speaker>> mockCall;

    @Captor
    private ArgumentCaptor<Callback<List<Speaker>>> captor;

    private SpeakerListPresenter presenter;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        presenter = new SpeakerListPresenter(codeMashAPI, view);
    }


    @Test
    public void test_GetPresenterStarted(){

        // arrange
        List<Speaker> speakers  = new ArrayList<>();
        speakers.add(new Speaker());

        when(codeMashAPI.GetSpeakers()).thenReturn(mockCall);
        Response<List<Speaker>> response = Response.success(speakers);

        // act
        presenter.start();

        // assert
        verify(mockCall).enqueue(captor.capture());
        captor.getValue().onResponse(null, response);

        verify(view).showLoading();
        verify(view).hideLoading();

        verify(view).updateSpeakerList(speakers);
    }
}
