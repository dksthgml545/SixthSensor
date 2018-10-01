package kr.ac.kopo.hdyw0w.sixthsensor.item;

import com.google.gson.annotations.SerializedName;

public class LoginItem {

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}

class Data {
    @SerializedName("user")
    private User user;
}

class User {

    @SerializedName("userid")
    private String userid;
    @SerializedName("username")
    private String username;
    @SerializedName("token")
    private String token;

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