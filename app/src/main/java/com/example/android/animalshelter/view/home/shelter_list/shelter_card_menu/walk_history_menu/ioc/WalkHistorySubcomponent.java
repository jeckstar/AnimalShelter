package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.ioc;

import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.WalkHistoryFragment;

import dagger.Subcomponent;

@WalkHistoryScope
@Subcomponent(modules = {WalkHistoryModule.class})
public interface WalkHistorySubcomponent {

    void inject(WalkHistoryFragment fragment);
}
