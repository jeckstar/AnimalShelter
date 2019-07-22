
package com.example.android.network.route.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ManeuverDto {

    @SerializedName("distance")
    @Expose
    private double distance;
    @SerializedName("streets")
    @Expose
    private List<String> streets = null;
    @SerializedName("startPoint")
    @Expose
    private StartPointDto startPoint;
    @SerializedName("index")
    @Expose
    private int index;
    @SerializedName("formattedTime")
    @Expose
    private String formattedTime;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<String> getStreets() {
        return streets;
    }

    public void setStreets(List<String> streets) {
        this.streets = streets;
    }

    public StartPointDto getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(StartPointDto startPoint) {
        this.startPoint = startPoint;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFormattedTime() {
        return formattedTime;
    }

    public void setFormattedTime(String formattedTime) {
        this.formattedTime = formattedTime;
    }

}
