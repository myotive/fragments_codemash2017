package com.example.myotive.codemash_common;

import android.app.Application;
import android.content.Context;

import com.example.myotive.codemash_common.di.ApplicationComponent;
import com.example.myotive.codemash_common.di.DaggerApplicationComponent;
import com.example.myotive.codemash_common.di.NetworkModule;

import net.danlew.android.joda.JodaTimeAndroid;

/**
 * Created by michaelyotive_hr on 12/3/16.
 */

public class BaseApplication extends Application {

    ApplicationComponent applicationComponent;

    /**
     * Helper method to obtain SampleApplication class from context.
     * @param context
     * @return SampleApplication
     */
    public static BaseApplication getApplication(Context context){
        return (BaseApplication)context.getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);

        applicationComponent = DaggerApplicationComponent
                .builder()
                .networkModule(new NetworkModule())
                .build();
    }
}
