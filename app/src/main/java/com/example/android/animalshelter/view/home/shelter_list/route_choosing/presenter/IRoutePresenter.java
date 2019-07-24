package com.example.android.animalshelter.view.home.shelter_list.route_choosing.presenter;

import com.example.android.animalshelter.view.home.shelter_list.route_choosing.view.IRouteView;
import com.example.android.animalshelter.view.presenter.Presenter;
import com.jeka.golub.shelter.domain.route.Location;

public interface IRoutePresenter extends Presenter<IRouteView> {

    void onShowSelectedItem();

    void onTakeAnimalForAWalk();

    void onCreateRoute(Location from, Location to);
}
