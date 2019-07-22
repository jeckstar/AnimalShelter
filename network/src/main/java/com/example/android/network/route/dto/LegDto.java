
package com.example.android.network.route.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LegDto {

    @SerializedName("distance")
    @Expose
    private double distance;
    @SerializedName("maneuvers")
    @Expose
    private List<ManeuverDto> maneuvers = null;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<ManeuverDto> getManeuvers() {
        return maneuvers;
    }

    public void setManeuvers(List<ManeuverDto> maneuvers) {
        this.maneuvers = maneuvers;
    }

}
