package com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.ioc;

import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.AnimalMenuFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {AnimalMenuModule.class})
public interface AnimalMenuSubcomponent {

    void inject(AnimalMenuFragment fragment);
}
