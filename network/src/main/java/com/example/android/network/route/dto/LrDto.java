
package com.example.android.network.route.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LrDto {

    @SerializedName("lng")
    @Expose
    private double lng;
    @SerializedName("lat")
    @Expose
    private double lat;

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

}
