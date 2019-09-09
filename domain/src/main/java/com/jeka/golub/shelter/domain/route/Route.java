package com.jeka.golub.shelter.domain.route;

import java.util.List;
import java.util.Objects;

public class Route {

    private final double distance;
    private final List<Location> locations;
    private long walkId;


    public Route(double distance, List<Location> locations) {
        this.distance = distance;
        this.locations = locations;
    }

    public Route(List<Location> locations, long walkId) {
        this.distance = 0.0;
        this.locations = locations;
        this.walkId = walkId;
    }

    public double getDistance() {
        if (distance != 0.0) {
            return distance;
        } else {
            throw new NullPointerException();
        }
    }

    public List<Location> getLocations() {
        return locations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Double.compare(route.distance, distance) == 0 &&
                Objects.equals(locations, route.locations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, locations);
    }

    @Override
    public String toString() {
        return "Route{" +
                "distance=" + distance +
                ", locations=" + locations +
                '}';
    }

    public long getWalkId() {
        if (walkId != 0.0) {
            return walkId;
        } else {
            throw new NullPointerException();
        }
    }
}
