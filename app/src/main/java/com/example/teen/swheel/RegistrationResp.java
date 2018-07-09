package com.example.teen.swheel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationResp {

    @SerializedName("loginExists")
    @Expose
    private boolean loginExists;
    @SerializedName("mailExists")
    @Expose
    private boolean mailExists;

    public boolean getLoginExists() {
        return loginExists;
    }

    public void setLoginExists(boolean loginExists) {
        this.loginExists = loginExists;
    }

    public boolean getMailExists() {
        return mailExists;
    }

    public void setMailExists(boolean mailExists) {
        this.mailExists = mailExists;
    }

}