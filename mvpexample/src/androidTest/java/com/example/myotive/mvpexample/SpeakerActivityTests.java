package com.example.myotive.mvpexample;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.myotive.codemash_common.BaseApplication;
import com.example.myotive.codemash_common.di.ApplicationComponent;
import com.example.myotive.codemash_common.tests.RecyclerViewAssertion;
import com.example.myotive.mvpexample.di.MockedNetworkModule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import it.cosenonjaviste.daggermock.DaggerMockRule;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by michaelyotive_hr on 12/31/16.
 */
@RunWith(AndroidJUnit4.class) @LargeTest
public class SpeakerActivityTests {

    private static final String TAG = SpeakerActivityTests.class.getSimpleName();

    // Retrofit Mock Web Server
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


    @Before
    public void testSetup() {
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
    public void test_ListOfSpeakers() {

        // arrange
        givenIHaveAListOfSpeakers();

        // act
        startActivity();

        // assert
        onView(withId(R.id.rv_speakers)).check(new RecyclerViewAssertion(1));
    }

    @Test
    public void test_SpeakerDetail(){
        // arrange
        givenIHaveAListOfSpeakers();

        // act
        startActivity();

        // assert
        onView(withId(R.id.rv_speakers)).perform(RecyclerViewActions
                .actionOnItemAtPosition(0,
                        RecyclerViewAssertion.clickChildViewWithId(R.id.speaker_profile_image)));

        onView(withText("Michael Yotive")).check(matches(isDisplayed()));
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
