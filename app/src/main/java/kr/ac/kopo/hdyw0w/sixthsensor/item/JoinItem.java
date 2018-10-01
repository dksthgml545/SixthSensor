package kr.ac.kopo.hdyw0w.sixthsensor.item;

import android.util.DisplayMetrics;

import com.google.gson.annotations.SerializedName;

public class JoinItem {

    @SerializedName("userid")
    private String userid;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("status")
    private String status;

    // Setter
    public void setUsername(String username){
        this.username = username;
    }

    public void setUser_id(String userid){
        this.userid = userid;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setStatus(String status){
        this.status = status;
    }

    // Getter
    public String getUsername(){
        return username;
    }

    public String getUserid(){
        return userid;
    }

    public String getPassword(){
        return password;
    }

    public String getStatus() {
        return status;
    }

}
