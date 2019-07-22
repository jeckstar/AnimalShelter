package com.jeka.golub.shelter.domain.route;

import java.util.List;
import java.util.Objects;

public class Route {

    private final double distance;
    private final List<Location> locations;

    public Route(double distance, List<Location> locations) {
        this.distance = distance;
        this.locations = locations;
    }

    public double getDistance() {
        return distance;
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
}
