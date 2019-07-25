package com.jeka.golub.shelter.domain.route;

public interface RouteRepository {

    void add(Route route);

    Route getRouteByWalkId(long walkId);
}
