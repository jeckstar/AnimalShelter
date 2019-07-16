package com.example.android.animalshelter.view.home.shelter_list.choose_shelter.ioc;

import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.ChoosingShelterFragment;

import dagger.Subcomponent;

@Subcomponent(modules = ChoosingShelterModule.class)
public interface ChoosingShelterSubcomponent {

    void inject(ChoosingShelterFragment fragment);
}
