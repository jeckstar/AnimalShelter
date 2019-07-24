package com.example.android.network.route;

import com.jeka.golub.shelter.domain.route.Location;
import com.jeka.golub.shelter.domain.route.Route;
import com.jeka.golub.shelter.domain.route.RouteResolvationException;
import com.jeka.golub.shelter.domain.route.RouteService;

import java.io.IOException;

public class MapQuestRetrofitRouteService implements RouteService {
    private final RetrofitRouteController controller;
    private final RouteFactory factory;

    public MapQuestRetrofitRouteService(RetrofitRouteController controller, RouteFactory factory) {
        this.controller = controller;
        this.factory = factory;
    }

    @Override
    public Route getRoute(Location from, Location to) {
        try {
            return factory.createRoute(controller.getRoute(from.toString(), to.toString()).execute().body().getRoute());
        } catch (IOException e) {
            throw new RouteResolvationException("Could not resolve route between " + from + " and " + to, e);
        }
    }
}
