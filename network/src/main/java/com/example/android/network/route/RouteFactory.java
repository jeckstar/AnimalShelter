package com.example.android.network.route;

import com.example.android.network.route.dto.response.RouteDto;
import com.example.android.network.route.dto.response.ShapeDto;
import com.jeka.golub.shelter.domain.route.Location;
import com.jeka.golub.shelter.domain.route.Route;

import java.util.ArrayList;
import java.util.List;

public class RouteFactory {

    Route createRoute(RouteDto routeDto) {
        List<Location> locations = new ArrayList<>();
        ShapeDto shape = routeDto.getShape();
        for (ShapeDto.Point shapePoint : shape.getShapePoints()) {
            locations.add(
                    Location.createLocation(
                            shapePoint.getLatitude(),
                            shapePoint.getLongitude()
                    )
            );
        }
        return new Route(
                routeDto.getDistance(),
                locations
        );
    }
}
