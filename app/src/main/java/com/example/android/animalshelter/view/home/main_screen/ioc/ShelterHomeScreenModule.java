package com.example.android.animalshelter.view.home.main_screen.ioc;

import com.example.android.animalshelter.view.home.main_screen.ShelterHomeScreenActivity;
import com.example.android.animalshelter.view.home.main_screen.presenter.IShelterHomePresenter;
import com.example.android.animalshelter.view.home.main_screen.presenter.ShelterHomePresenter;
import com.example.android.animalshelter.view.home.main_screen.view.IShelterHomeView;
import com.example.android.animalshelter.view.home.main_screen.view.ShelterHomeView;

import dagger.Module;
import dagger.Provides;

@Module
public class ShelterHomeScreenModule {

    private final IShelterHomeView view;

    public ShelterHomeScreenModule(ShelterHomeScreenActivity activity) {
        this.view = new ShelterHomeView(activity);
    }

    @Provides
    public IShelterHomeView getShelterHomeView() {
        return view;
    }

    @Provides
    public IShelterHomePresenter getShelterHomePresenter(IShelterHomeView view){
        return new ShelterHomePresenter(view);
    }
}
