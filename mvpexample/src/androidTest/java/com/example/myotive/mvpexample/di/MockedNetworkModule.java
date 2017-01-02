package com.example.myotive.mvpexample.di;

import com.example.myotive.codemash_common.di.NetworkModule;

import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by michaelyotive_hr on 1/1/17.
 */
public class MockedNetworkModule extends NetworkModule {

    private MockWebServer mockWebServer;

    public MockedNetworkModule(MockWebServer mockWebServer) {
        this.mockWebServer = mockWebServer;
    }

    @Override
    public Retrofit provideRetrofit(OkHttpClient client) {

        return new Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
