package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.ioc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.view.IRouteDisplayView;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.view.RouteDisplayView;

import javax.inject.Inject;

public class RouteDisplayViewFactory {

    @Inject
    public RouteDisplayViewFactory() {

    }

    public IRouteDisplayView createView(@NonNull LayoutInflater inflater,
                                        ViewGroup container,
                                        Bundle savedInstanceState) {
        return new RouteDisplayView(
                inflater,
                container,
                savedInstanceState
        );
    }
}
