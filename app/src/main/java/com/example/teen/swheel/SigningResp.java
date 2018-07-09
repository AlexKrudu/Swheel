package com.example.teen.swheel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SigningResp {

    @SerializedName("loginAndPasswordExist")
    @Expose
    private boolean loginAndPasswordExist;

    public boolean getLoginAndPasswordExist() {
        return loginAndPasswordExist;
    }

    public void setLoginAndPasswordExist(boolean loginAndPasswordExist) {
        this.loginAndPasswordExist = loginAndPasswordExist;
    }

}