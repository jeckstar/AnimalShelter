
package com.example.android.network.route.dto.request;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OptionsDto {

    @SerializedName("avoids")
    @Expose
    private List<Object> avoids = null;
    @SerializedName("avoidTimedConditions")
    @Expose
    private Boolean avoidTimedConditions;
    @SerializedName("doReverseGeocode")
    @Expose
    private Boolean doReverseGeocode;
    @SerializedName("shapeFormat")
    @Expose
    private String shapeFormat;
    @SerializedName("generalize")
    @Expose
    private Integer generalize;
    @SerializedName("routeType")
    @Expose
    private String routeType;
    @SerializedName("timeType")
    @Expose
    private Integer timeType;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("enhancedNarrative")
    @Expose
    private Boolean enhancedNarrative;
    @SerializedName("drivingStyle")
    @Expose
    private Integer drivingStyle;
    @SerializedName("highwayEfficiency")
    @Expose
    private Double highwayEfficiency;

    public List<Object> getAvoids() {
        return avoids;
    }

    public void setAvoids(List<Object> avoids) {
        this.avoids = avoids;
    }

    public Boolean getAvoidTimedConditions() {
        return avoidTimedConditions;
    }

    public void setAvoidTimedConditions(Boolean avoidTimedConditions) {
        this.avoidTimedConditions = avoidTimedConditions;
    }

    public Boolean getDoReverseGeocode() {
        return doReverseGeocode;
    }

    public void setDoReverseGeocode(Boolean doReverseGeocode) {
        this.doReverseGeocode = doReverseGeocode;
    }

    public String getShapeFormat() {
        return shapeFormat;
    }

    public void setShapeFormat(String shapeFormat) {
        this.shapeFormat = shapeFormat;
    }

    public Integer getGeneralize() {
        return generalize;
    }

    public void setGeneralize(Integer generalize) {
        this.generalize = generalize;
    }

    public String getRouteType() {
        return routeType;
    }

    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Boolean getEnhancedNarrative() {
        return enhancedNarrative;
    }

    public void setEnhancedNarrative(Boolean enhancedNarrative) {
        this.enhancedNarrative = enhancedNarrative;
    }

    public Integer getDrivingStyle() {
        return drivingStyle;
    }

    public void setDrivingStyle(Integer drivingStyle) {
        this.drivingStyle = drivingStyle;
    }

    public Double getHighwayEfficiency() {
        return highwayEfficiency;
    }

    public void setHighwayEfficiency(Double highwayEfficiency) {
        this.highwayEfficiency = highwayEfficiency;
    }

}
