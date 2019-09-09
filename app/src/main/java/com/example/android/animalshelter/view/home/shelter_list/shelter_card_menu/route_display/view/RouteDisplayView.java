package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.view.home.shelter_list.route_choosing.model.LocationPM;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;

import java9.util.stream.Collectors;
import java9.util.stream.StreamSupport;

public class RouteDisplayView implements IRouteDisplayView {

    private View rootView;
    private GoogleMap mMap;


    public RouteDisplayView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_route_display, container, false);
    }

    @Override
    public View getAndroidView() {
        return rootView;
    }

    @Override
    public void drawPolyline(List<LocationPM> locations) {
        mMap.addPolyline(new PolylineOptions().addAll(
                StreamSupport.stream(locations)
                        .map(LocationPM::asLatLng)
                        .collect(Collectors.toList())
        ));
        if (!locations.isEmpty()) {
            locations.get(0).asLatLng();
            LatLng start = locations.get(0).asLatLng();
            mMap.addMarker(new MarkerOptions().position(start).title("Start of the route"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(start, 14f));
        }
    }

    @Override
    public void withMap(GoogleMap googleMap) {
        this.mMap = googleMap;
    }
}
