
package com.example.android.network.route.dto.request;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RouteDefinitionDTO {

    @SerializedName("locations")
    @Expose
    private List<String> locations = null;
    @SerializedName("options")
    @Expose
    private OptionsDto options;

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public OptionsDto getOptions() {
        return options;
    }

    public void setOptions(OptionsDto options) {
        this.options = options;
    }

}
