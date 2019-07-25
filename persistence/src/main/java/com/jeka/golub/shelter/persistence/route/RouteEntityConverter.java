package com.jeka.golub.shelter.persistence.route;

import com.jeka.golub.shelter.domain.route.Location;


public class RouteEntityConverter {
    public LocationEntity convertForward(Location subject, long index) {
        return new LocationEntity(
                String.valueOf(subject.getLatitude()),
                String.valueOf(subject.getLongitude()),
                subject.getWalkId(),
                index
        );
    }

    public Location convertReverse(LocationEntity subject) {
        return Location.createLocation(
                Double.parseDouble(subject.getLatitude()),
                Double.parseDouble(subject.getLongitude()),
                subject.getIndex()
        );
    }
}
