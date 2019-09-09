package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.view;

import android.view.View;

import com.example.android.animalshelter.view.home.shelter_list.route_choosing.model.LocationPM;
import com.google.android.gms.maps.GoogleMap;

import java.util.List;

public interface IRouteDisplayView {
    View getAndroidView();

    void drawPolyline(List<LocationPM> locations);

    void withMap(GoogleMap googleMap);
}
