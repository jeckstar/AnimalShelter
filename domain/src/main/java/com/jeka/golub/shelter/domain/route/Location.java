package com.jeka.golub.shelter.domain.route;

import java.util.Objects;

public class Location {

    private final double latitude;
    private final double longitude;

    private Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.latitude, latitude) == 0 &&
                Double.compare(location.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    @Override
    public String toString() {
        return latitude + "," + longitude;
    }

    public static Location createLocation(double latitude, double longitude) {
        return new Location(latitude, longitude);
    }
}
