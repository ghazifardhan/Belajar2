package org.simonita.simonita.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Riesto on 26/01/2017.
 */

public class Data {
    @SerializedName("data")
    @Expose
    private List<Models> data = null;

    public List<Models> getData() {
        return data;
    }

    public void setData(List<Models> data) {
        this.data = data;
    }
}
