package com.example.android.network.route;

import com.example.android.network.route.dto.request.OptionsDto;
import com.example.android.network.route.dto.request.RouteDefinitionDTO;
import com.jeka.golub.shelter.domain.route.Location;
import com.jeka.golub.shelter.domain.route.Route;
import com.jeka.golub.shelter.domain.route.RouteResolvationException;
import com.jeka.golub.shelter.domain.route.RouteService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapQuestRetrofitRouteService implements RouteService {
    private final RetrofitRouteController controller;
    private final RouteFactory factory;

    public MapQuestRetrofitRouteService(RetrofitRouteController controller, RouteFactory factory) {
        this.controller = controller;
        this.factory = factory;
    }

    @Override
    public Route getRoute(Location from, Location to) {
        RouteDefinitionDTO request = constructRequest(from, to);
        try {
            return factory.createRoute(
                    controller.getRoute(request)
                            .execute()
                            .body()
                            .getRoute());
        } catch (IOException e) {
            throw new RouteResolvationException("Could not resolve route between " + from + " and " + to, e);
        }
    }

    private RouteDefinitionDTO constructRequest(Location from, Location to) {
        RouteDefinitionDTO request = new RouteDefinitionDTO();
        OptionsDto options = new OptionsDto();
        options.setGeneralize(0);
        options.setRouteType("pedestrian");
        request.setOptions(options);
        List<String> locations = new ArrayList<>(2);
        locations.add(from.toString());
        locations.add(to.toString());
        request.setLocations(locations);
        return request;
    }
}
