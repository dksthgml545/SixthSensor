package kr.ac.kopo.hdyw0w.sixthsensor.item;

import com.google.gson.annotations.SerializedName;

public class Devices {

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName("deviceName")
    private String deviceName;

    @SerializedName("totalSensorsCnt")
    private int totalSensorsCnt;

    @SerializedName("errSensorsCnt")
    private int errSensorsCnt;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getTotalSensorsCnt() {
        return totalSensorsCnt;
    }

    public void setTotalSensorsCnt(int totalSensorsCnt) {
        this.totalSensorsCnt = totalSensorsCnt;
    }

    public int getErrSensorsCnt() {
        return errSensorsCnt;
    }

    public void setErrSensorsCnt(int errSensorsCnt) {
        this.errSensorsCnt = errSensorsCnt;
    }
}
