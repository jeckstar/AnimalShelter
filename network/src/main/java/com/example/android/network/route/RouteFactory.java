package com.example.android.network.route;

import com.example.android.network.route.dto.LegDto;
import com.example.android.network.route.dto.ManeuverDto;
import com.example.android.network.route.dto.RouteDto;
import com.jeka.golub.shelter.domain.route.Location;
import com.jeka.golub.shelter.domain.route.Route;

import java.util.ArrayList;
import java.util.List;

public class RouteFactory {

    public Route createRoute(RouteDto routeDto) {
        List<Location> locations = new ArrayList<>();
        final LegDto leg = routeDto.getLegs().get(0);
        final String sessionId = routeDto.getSessionId();
        for (ManeuverDto maneuverDto : leg.getManeuvers()) {
            locations.add(
                    Location.createLocation(
                            maneuverDto.getStartPoint().getLat(),
                            maneuverDto.getStartPoint().getLng()
                    )
            );
        }
        return new Route(
                routeDto.getDistance(),
                locations,
                sessionId
        );
    }
}
