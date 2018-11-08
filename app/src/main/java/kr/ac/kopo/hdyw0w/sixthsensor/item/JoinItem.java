package kr.ac.kopo.hdyw0w.sixthsensor.item;

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

    public data getData() {
        return data;
    }

    public void setData(data Data) {
        this.data = Data;
    }

}

class data {

    @SerializedName("JoinUser")
    private JoinUser JoinUser;

    public kr.ac.kopo.hdyw0w.sixthsensor.item.JoinUser getJoinUser() {
        return JoinUser;
    }

    public void setJoinUser(kr.ac.kopo.hdyw0w.sixthsensor.item.JoinUser joinUser) {
        JoinUser = joinUser;
    }
}