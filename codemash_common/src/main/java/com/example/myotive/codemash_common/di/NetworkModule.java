package com.example.myotive.codemash_common.di;

import com.example.myotive.codemash_common.BuildConfig;
import com.example.myotive.codemash_common.di.scopes.ApplicationScope;
import com.example.myotive.codemash_common.network.CodeMashAPI;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by michaelyotive_hr on 12/3/16.
 */
@Module
public class NetworkModule {

    @Provides
    @ApplicationScope
    public Retrofit provideRetrofit(OkHttpClient client){

        return new Retrofit.Builder()
                .baseUrl("https://speakers.codemash.org/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @ApplicationScope
    public OkHttpClient provideHttpClient(HttpLoggingInterceptor logging){

        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
    }

    @Provides
    @ApplicationScope
    public HttpLoggingInterceptor provideInterceptor(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        return logging;
    }

    @Provides
    @ApplicationScope
    public CodeMashAPI provideCodeMashAPI(Retrofit retrofit){
        return retrofit.create(CodeMashAPI.class);
    }
}
