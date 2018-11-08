package kr.ac.kopo.hdyw0w.sixthsensor.item;

import com.google.gson.annotations.SerializedName;

public class AllDeviceListItem {

    @SerializedName("status")
    public String status;

    @SerializedName("Data")
    private AllDeviceData data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AllDeviceData getData() {
        return data;
    }

    public void setData(AllDeviceData data) {
        this.data = data;
    }
}


