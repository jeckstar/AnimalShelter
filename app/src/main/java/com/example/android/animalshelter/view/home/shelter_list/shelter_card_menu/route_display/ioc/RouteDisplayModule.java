package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.ioc;

import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.presenter.IRouteDisplayPresenter;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.presenter.RouteDisplayPresenter;
import com.jeka.golub.shelter.domain.route.RouteRepository;

import java.util.concurrent.Executors;

import dagger.Module;
import dagger.Provides;

@Module
@DisplayRouteScope
public class RouteDisplayModule {

    private final long walkId;

    public RouteDisplayModule(long walkId) {
        this.walkId = walkId;
    }

    @Provides
    @DisplayRouteScope
    public IRouteDisplayPresenter getRouteDisplayPresenter(RouteRepository routeRepository) {
        return new RouteDisplayPresenter(
                routeRepository,
                Executors.newCachedThreadPool(),
                walkId);
    }

}
