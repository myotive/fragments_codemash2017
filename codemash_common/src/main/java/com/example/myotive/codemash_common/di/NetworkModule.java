package com.example.myotive.codemash_common.di;

import com.example.myotive.codemash_common.di.scopes.ApplicationScope;
import com.example.myotive.codemash_common.network.CodeMashAPI;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by michaelyotive_hr on 12/3/16.
 */
@Module
public class NetworkModule {

    @Provides
    @ApplicationScope
    Retrofit provideRetrofit(){

        return new Retrofit.Builder()
                .baseUrl("https://speakers.codemash.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @ApplicationScope
    CodeMashAPI provideCodeMashAPI(Retrofit retrofit){
        return retrofit.create(CodeMashAPI.class);
    }
}
