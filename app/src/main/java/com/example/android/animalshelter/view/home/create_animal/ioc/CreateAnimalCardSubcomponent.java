package com.example.android.animalshelter.view.home.create_animal.ioc;

import com.example.android.animalshelter.view.home.create_animal.CreateAnimalCardFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {CreateAnimalCardModule.class})
public interface CreateAnimalCardSubcomponent {

    void inject (CreateAnimalCardFragment fragment);
}


