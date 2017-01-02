package com.example.myotive.mvpexample;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.myotive.codemash_common.BaseApplication;
import com.example.myotive.codemash_common.di.ApplicationComponent;
import com.example.myotive.codemash_common.tests.RecyclerViewItemCountAssertion;
import com.example.myotive.mvpexample.di.MockedNetworkModule;
import com.example.myotive.mvpexample.speakerlist.SpeakerListContract;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import it.cosenonjaviste.daggermock.DaggerMockRule;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.mockito.Mockito.verify;

/**
 * Created by michaelyotive_hr on 12/31/16.
 */
@RunWith(AndroidJUnit4.class) @LargeTest
public class SpeakerActivityTests {

    private static final String TAG = SpeakerActivityTests.class.getSimpleName();

    private BaseApplication app;
    private MockWebServer mockWebServer = new MockWebServer();

   @Rule public DaggerMockRule<ApplicationComponent> daggerRule =
            new DaggerMockRule<>(ApplicationComponent.class, new MockedNetworkModule(mockWebServer)).set(
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

    @Before
    public void testSetup() {
        MockitoAnnotations.initMocks(this);

        app =  (BaseApplication) InstrumentationRegistry.getInstrumentation()
                        .getTargetContext()
                        .getApplicationContext();
        try {
            mockWebServer.start();
        } catch (IOException e) {
            Log.e(TAG, "Could not start mock web server", e);
        }
    }

    @After
    public void testTearDown(){
        try {
            mockWebServer.shutdown();
        } catch (IOException e) {
            Log.e(TAG, "Could not stop mock web server", e);
        }
    }

    @Test
    public void testHappyPath() {
        givenIHaveAListOfSpeakers();

        startActivity();

        onView(withId(R.id.rv_speakers)).check(new RecyclerViewItemCountAssertion(1));
    }

    private void givenIHaveAListOfSpeakers() {
        MockResponse response = new MockResponse();
        response.setResponseCode(200);

        try {
            response.setBody(AssetStringHelper.readAssetString("mock_speaker_response.json"));
        } catch (IOException e) {
            Log.e(TAG, "Could not read file.", e);
        }

        mockWebServer.enqueue(response);
    }


    private SpeakerActivity startActivity() {
        return speakerActivityIntentsTestRule.launchActivity(null);
    }
}
