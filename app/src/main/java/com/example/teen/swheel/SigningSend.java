package com.example.teen.swheel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SigningSend {

    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("password")
    @Expose
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
