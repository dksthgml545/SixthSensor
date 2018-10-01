package kr.ac.kopo.hdyw0w.sixthsensor.item;

import com.google.gson.annotations.SerializedName;

public class PassChItem {

    @SerializedName("status")
    private String status;

    @SerializedName("userid")
    private String userid;

    @SerializedName("password")
    private String password;

    @SerializedName("newPassword")
    private String newPassword;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
