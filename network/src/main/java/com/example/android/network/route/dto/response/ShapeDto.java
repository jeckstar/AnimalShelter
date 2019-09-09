package com.example.android.network.route.dto.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ShapeDto {

    @SerializedName("legIndexes")
    @Expose
    private List<Integer> legIndexes = null;
    @SerializedName("maneuverIndexes")
    @Expose
    private List<Integer> maneuverIndexes = null;
    @SerializedName("shapePoints")
    @Expose
    private List<Double> shapePoints = null;

    public List<Integer> getLegIndexes() {
        return legIndexes;
    }

    public void setLegIndexes(List<Integer> legIndexes) {
        this.legIndexes = legIndexes;
    }

    public List<Integer> getManeuverIndexes() {
        return maneuverIndexes;
    }

    public void setManeuverIndexes(List<Integer> maneuverIndexes) {
        this.maneuverIndexes = maneuverIndexes;
    }

    public Collection<Point> getShapePoints() {
        Collection<Point> points = new ArrayList<>();
        for (int i = 0; i < shapePoints.size(); i += 2) {
            points.add(new Point(this.shapePoints.get(i), this.shapePoints.get(i + 1)));
        }
        return points;
    }

    public void setShapePoints(List<Double> shapePoints) {
        this.shapePoints = shapePoints;
    }

    public static class Point {
        private final double latitude;
        private final double longitude;

        private Point(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }
    }

}
