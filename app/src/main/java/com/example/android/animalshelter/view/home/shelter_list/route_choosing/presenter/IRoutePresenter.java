package com.example.android.animalshelter.view.home.shelter_list.route_choosing.presenter;

import com.example.android.animalshelter.view.home.shelter_list.route_choosing.IUserLocation;
import com.example.android.animalshelter.view.home.shelter_list.route_choosing.view.IRouteView;
import com.example.android.animalshelter.view.home.shelter_list.route_choosing.view.RouteView;
import com.example.android.animalshelter.view.presenter.Presenter;
import com.google.android.gms.maps.GoogleMap;
import com.jeka.golub.shelter.domain.route.Location;

import java.util.List;

public interface IRoutePresenter extends Presenter<IRouteView> {

    void onCreate(IUserLocation userLocation, RouteView view);

    void onShowSelectedItem();

    void onTakeAnimalForAWalk();

    void onCreateRoute(Location from, Location to);

    void findLocation();

    void attachMap(GoogleMap mMap);
}
