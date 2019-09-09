package com.example.android.animalshelter.view.home.main_screen.ioc;

import com.example.android.animalshelter.view.home.main_screen.ShelterHomeScreenActivity;

import dagger.Subcomponent;

@HomeScreenScope
@Subcomponent(modules = {ShelterHomeScreenModule.class})
public interface HomeScreenSubcomponent {

    void inject(ShelterHomeScreenActivity activity);
}
