package com.example.teen.swheel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetCoords {

    @SerializedName("success")
    @Expose
    private boolean success;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}