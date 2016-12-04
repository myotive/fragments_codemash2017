package com.example.myotive.codemash_common.network;

import com.example.myotive.codemash_common.network.models.Session;
import com.example.myotive.codemash_common.network.models.Speaker;

import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by michaelyotive_hr on 12/3/16.
 */

public interface CodeMashAPI {
    @GET("api/SessionsData")
    Call<List<Session>> GetSessions();

    @GET("api/SessionsData/{id}")
    Call<Session> GetSessionById(@Path("id") UUID id);

    @GET("api/SpeakersData")
    Call<List<Speaker>> GetSpeakers();

    @GET("api/SpeakersData/{id}")
    Call<Speaker> GetSpeakerById(@Path("id") UUID id);
}
