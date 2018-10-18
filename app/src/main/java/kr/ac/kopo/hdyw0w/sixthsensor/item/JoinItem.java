package kr.ac.kopo.hdyw0w.sixthsensor.item;

import android.util.DisplayMetrics;

import com.google.gson.annotations.SerializedName;

public class JoinItem {

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public kr.ac.kopo.hdyw0w.sixthsensor.item.data getData() {
        return data;
    }

    public void setData(kr.ac.kopo.hdyw0w.sixthsensor.item.data data) {
        this.data = data;
    }
}

class data {

    @SerializedName("user")
    private user user;

    public kr.ac.kopo.hdyw0w.sixthsensor.item.user getUser() {
        return user;
    }

    public void setUser(kr.ac.kopo.hdyw0w.sixthsensor.item.user user) {
        this.user = user;
    }
}

class user {

    @SerializedName("userid")
    private String userid;

    @SerializedName("username")
    private String username;

    @SerializedName("token")
    private String token;

//    @SerializedName("password")
//    private String password;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
