package com.example.android.animalshelter.view.home.create_shelter.ioc;

import com.example.android.animalshelter.view.home.create_shelter.CreateShelterCardFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {CreateShelterCardModule.class})
public interface CreateShelterSubcomponent {

    void inject(CreateShelterCardFragment fragment);
}
