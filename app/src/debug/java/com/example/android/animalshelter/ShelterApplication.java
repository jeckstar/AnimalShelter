package com.example.android.animalshelter;

import android.app.Application;

import com.example.android.animalshelter.dagger.DependencyInjection;
import com.facebook.stetho.Stetho;

public class ShelterApplication extends Application {

    private DependencyInjection injection;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        injection = new DependencyInjection(this);
    }

    public DependencyInjection dependencyInjection() {
        return injection;
    }

}


