package com.example.myotive.codemash_common.di;

import com.example.myotive.codemash_common.di.scopes.ApplicationScope;
import com.example.myotive.codemash_common.network.CodeMashAPI;

import dagger.Component;

/**
 * Created by michaelyotive_hr on 12/3/16.
 */
@ApplicationScope
@Component(modules = { NetworkModule.class })
public interface ApplicationComponent {

    CodeMashAPI CodeMashAPI();
}
