package com.example.android.animalshelter.view.home.shelter_list.route_choosing;

import com.google.android.gms.maps.GoogleMap;

public interface IUserLocation {
    void attachMap(GoogleMap mMap);

    void findLocation();
}
