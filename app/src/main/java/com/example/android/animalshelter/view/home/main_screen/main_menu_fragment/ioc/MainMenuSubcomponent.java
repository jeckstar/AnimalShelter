package com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.ioc;

import com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.MainMenuFragment;

import dagger.Subcomponent;

@Subcomponent(modules = MainMenuModule.class)
public interface MainMenuSubcomponent {

    void inject(MainMenuFragment fragment);
}
