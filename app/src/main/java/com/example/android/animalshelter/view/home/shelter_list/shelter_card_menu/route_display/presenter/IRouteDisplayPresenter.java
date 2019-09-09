package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.presenter;


import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.view.IRouteDisplayView;
import com.example.android.animalshelter.view.presenter.Presenter;

public interface IRouteDisplayPresenter extends Presenter<IRouteDisplayView> {

    void onCreate(IRouteDisplayView view);

    void onDisplayRoute();

}
