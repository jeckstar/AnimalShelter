package com.example.android.animalshelter.view.home.main_screen.ioc;

import com.example.android.animalshelter.view.home.main_screen.presenter.IShelterHomePresenter;
import com.example.android.animalshelter.view.home.main_screen.presenter.ShelterHomePresenter;
import com.example.android.animalshelter.view.home.main_screen.view.IShelterHomeView;

import dagger.Module;
import dagger.Provides;

@Module
@HomeScreenScope
public class ShelterHomeScreenModule {

    @Provides
    @HomeScreenScope
    public IShelterHomePresenter getShelterHomePresenter() {
        return new ShelterHomePresenter();
    }
}

