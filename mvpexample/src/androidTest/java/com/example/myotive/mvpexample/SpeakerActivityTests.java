package com.example.myotive.mvpexample;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.core.deps.guava.base.Verify;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.example.myotive.codemash_common.BaseApplication;
import com.example.myotive.codemash_common.di.ApplicationComponent;
import com.example.myotive.codemash_common.di.NetworkModule;
import com.example.myotive.codemash_common.network.CodeMashAPI;
import com.example.myotive.codemash_common.network.models.Session;
import com.example.myotive.codemash_common.network.models.Speaker;
import com.example.myotive.codemash_common.tests.RecyclerViewItemCountAssertion;
import com.example.myotive.mvpexample.speakerlist.SpeakerListContract;
import com.example.myotive.mvpexample.speakerlist.SpeakerListPresenter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import it.cosenonjaviste.daggermock.DaggerMockRule;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by michaelyotive_hr on 12/31/16.
 */
@RunWith(AndroidJUnit4.class) @LargeTest
public class SpeakerActivityTests {

   @Rule public DaggerMockRule<ApplicationComponent> daggerRule =
            new DaggerMockRule<>(ApplicationComponent.class, new NetworkModule()).set(
                    new DaggerMockRule.ComponentSetter<ApplicationComponent>() {
                        @Override public void setComponent(ApplicationComponent component) {
                            BaseApplication app =
                                    (BaseApplication) InstrumentationRegistry.getInstrumentation()
                                            .getTargetContext()
                                            .getApplicationContext();
                            app.setComponent(component);
                        }
                    });

    @Rule
    public IntentsTestRule<SpeakerActivity> speakerActivityIntentsTestRule =
            new IntentsTestRule<>(SpeakerActivity.class, true, false);

    @Mock
    SpeakerListContract.View speakerView;

    @Captor
    ArgumentCaptor<Callback<List<Speaker>>> speakerCaptor;

    @Mock
    private CodeMashAPI codeMashAPI;

    @Mock
    private Call<List<Speaker>> mockedListOfSpeakers;

    private SpeakerListContract.Presenter speakerPresenter;
    private List<Speaker> speakerList;


    @Before
    public void testSetup() {
        MockitoAnnotations.initMocks(this);

        speakerList = getSpeakerList();
        speakerPresenter = new SpeakerListPresenter(codeMashAPI, speakerView);
    }

    @Test
    public void testHappyPath() {
        givenIHaveAListOfSpeakers();

        startActivity();

        verifySpeakerCall();

        onView(withId(R.id.rv_speakers)).check(new RecyclerViewItemCountAssertion(1));
    }

    private void givenIHaveAListOfSpeakers() {
        when(codeMashAPI.GetSpeakers()).thenReturn(mockedListOfSpeakers);
    }

    private void verifySpeakerCall() {
        List<Speaker> speakerList = getSpeakerList();

        Response<List<Speaker>> res =  Response.success(speakerList);
        speakerCaptor.getValue().onResponse(null, res);

        verify(mockedListOfSpeakers).enqueue(speakerCaptor.capture());
    }


    private SpeakerActivity startActivity() {
        return speakerActivityIntentsTestRule.launchActivity(null);
    }

    public List<Speaker> getSpeakerList() {
        Speaker speaker = new Speaker();
        speaker.setFirstName("Lorem");
        speaker.setLastName("Ipsum");

        List<Speaker> speakers = new ArrayList<>();
        speakers.add(speaker);

        return speakers;
    }
}
