package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.ioc;

import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.RouteDisplayFragment;

import dagger.Subcomponent;

@DisplayRouteScope
@Subcomponent(modules = {RouteDisplayModule.class})
public interface RouteDisplaySubcomponent {

    void inject(RouteDisplayFragment fragment);

}
