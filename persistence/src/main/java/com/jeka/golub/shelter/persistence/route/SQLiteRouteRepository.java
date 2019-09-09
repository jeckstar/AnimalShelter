package com.jeka.golub.shelter.persistence.route;

import com.jeka.golub.shelter.domain.route.Location;
import com.jeka.golub.shelter.domain.route.Route;
import com.jeka.golub.shelter.domain.route.RouteRepository;

import java.util.ArrayList;
import java.util.List;

public class SQLiteRouteRepository implements RouteRepository {

    private final RouteDao dao;
    private final RouteEntityConverter routeEntityConverter;

    public SQLiteRouteRepository(final RouteDao dao, final RouteEntityConverter routeEntityConverter) {
        this.dao = dao;
        this.routeEntityConverter = routeEntityConverter;
    }

    @Override
    public void add(Route route) {
        final List<Location> locations = route.getLocations();
        for (int i = 0; i < locations.size(); i++) {
            final LocationEntity locationEntity = routeEntityConverter.convertForward(
                    locations.get(i),
                    i
            );
            dao.insert(locationEntity);
        }
    }

    @Override
    public Route getRouteByWalkId(long walkId) {
        final List<Location> locations = new ArrayList<>();
        final List<LocationEntity> locationEntityList = dao.getRouteByWalkId(walkId);
        for (LocationEntity locationEntity : locationEntityList) {
            locations.add(routeEntityConverter.convertReverse(locationEntity));
        }
        return new Route(locations, walkId);
    }

}
