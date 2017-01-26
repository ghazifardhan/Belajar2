package org.simonita.simonita.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Models {

    @SerializedName("nama") // json variable nama in url
    @Expose // to expose json variable
    private String nama;
    @SerializedName("kota") // json variable kota in url
    @Expose  // to expose json variable
    private String kota;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}