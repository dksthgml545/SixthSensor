package kr.ac.kopo.hdyw0w.sixthsensor.item;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UpdateSensors {

    @SerializedName("deviceName")
    private String deviceName;
    @SerializedName("sensors")
    private ArrayList<Sensors> sensors;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public ArrayList<Sensors> getSensors() {
        return sensors;
    }

    public void setSensors(ArrayList<Sensors> sensors) {
        this.sensors = sensors;
    }
}
