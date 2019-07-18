package com.example.android.animalshelter.view.home.shelter_list.route_choosing.ioc;

import com.example.android.animalshelter.view.home.shelter_list.route_choosing.RouteMapActivity;

import dagger.Subcomponent;

@RouteScope
@Subcomponent(modules = {RouteModule.class})
public interface RouteSubcomponent {

    void inject(RouteMapActivity fragment);
}
