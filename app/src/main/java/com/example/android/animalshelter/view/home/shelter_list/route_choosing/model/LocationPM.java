package com.example.android.animalshelter.view.home.shelter_list.route_choosing.model;

import com.google.android.gms.maps.model.LatLng;
import com.jeka.golub.shelter.domain.route.Location;

import java.util.Objects;

public class LocationPM {

    private final double latitude;
    private final double longitude;

    public LocationPM(Location location) {
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
    }

    public LocationPM(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public LatLng asLatLng() {
        return new LatLng(this.latitude, this.longitude);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationPM that = (LocationPM) o;
        return Double.compare(that.latitude, latitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    @Override
    public String toString() {
        return "LocationPM{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
