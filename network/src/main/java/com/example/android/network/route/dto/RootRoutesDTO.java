
package com.example.android.network.route.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RootRoutesDTO {

    @SerializedName("route")
    @Expose
    private RouteDto route;

    public RouteDto getRoute() {
        return route;
    }

    public void setRoute(RouteDto route) {
        this.route = route;
    }

}
