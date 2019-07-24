
package com.example.android.network.route.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RouteDto {

    @SerializedName("boundingBox")
    @Expose
    private BoundingBoxDto boundingBox;
    @SerializedName("distance")
    @Expose
    private double distance;
    @SerializedName("legs")
    @Expose
    private List<LegDto> legs = null;
    @SerializedName("sessionId")
    @Expose
    private String sessionId;


    public BoundingBoxDto getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBoxDto boundingBox) {
        this.boundingBox = boundingBox;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<LegDto> getLegs() {
        return legs;
    }

    public void setLegs(List<LegDto> legs) {
        this.legs = legs;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
