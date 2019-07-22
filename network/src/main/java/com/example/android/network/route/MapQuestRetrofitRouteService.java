package com.example.android.network.route;

import com.example.android.network.exception.RequestFailedException;
import com.example.android.network.route.dto.RootRoutesDTO;
import com.jeka.golub.shelter.domain.route.Location;
import com.jeka.golub.shelter.domain.route.Route;
import com.jeka.golub.shelter.domain.route.RouteService;

import java.io.IOException;

import retrofit2.Response;

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
            Response<RootRoutesDTO> response = controller.getRoute(from.toString(), to.toString()).execute();
            if (response.isSuccessful()) {
                return factory.createRoute(response.body().getRoute());
            } else {
                throw new RequestFailedException(response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
