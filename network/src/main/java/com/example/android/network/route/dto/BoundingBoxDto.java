
package com.example.android.network.route.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BoundingBoxDto {

    @SerializedName("lr")
    @Expose
    private LrDto lr;
    @SerializedName("ul")
    @Expose
    private UlDto ul;

    public LrDto getLr() {
        return lr;
    }

    public void setLr(LrDto lr) {
        this.lr = lr;
    }

    public UlDto getUl() {
        return ul;
    }

    public void setUl(UlDto ul) {
        this.ul = ul;
    }

}
