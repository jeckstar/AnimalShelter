package com.example.android.animalshelter.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ShelterApplicationModule {

    private final Context context;

    public ShelterApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    Context context() {
        return context;
    }

}
