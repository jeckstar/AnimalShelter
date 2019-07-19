package com.example.android.animalshelter.view.home.shelter_list.route_choosing.presenter;

import com.example.android.animalshelter.view.home.shelter_list.route_choosing.view.IRouteView;
import com.example.android.animalshelter.view.presenter.Presenter;

public interface IRoutePresenter extends Presenter<IRouteView> {

    void onShowSelectedItem();

    void onTakeAnimalForAWalk();
}
