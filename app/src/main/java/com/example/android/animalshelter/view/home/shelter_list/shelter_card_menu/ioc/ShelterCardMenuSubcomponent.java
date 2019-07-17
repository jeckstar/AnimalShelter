package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ioc;

import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ShelterCardMenuFragment;

import dagger.Subcomponent;
@ShelterMenuScope
@Subcomponent(modules = {ShelterCardMenuModule.class})
public interface ShelterCardMenuSubcomponent {

    void inject(ShelterCardMenuFragment fragment);
}
