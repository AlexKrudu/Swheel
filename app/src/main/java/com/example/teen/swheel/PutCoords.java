package com.example.teen.swheel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PutCoords{

    @SerializedName("lattitude")
    @Expose
    private float lattitude;
    @SerializedName("longitude")
    @Expose
    private float longitude;

    public float getLattitude() {
        return lattitude;
    }

    public void setLattitude(float lattitude) {
        this.lattitude = lattitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

}