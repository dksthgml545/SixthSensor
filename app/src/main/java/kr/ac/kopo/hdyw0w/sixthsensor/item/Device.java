package kr.ac.kopo.hdyw0w.sixthsensor.item;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Device {

    // 라즈베리파이 ID
    @SerializedName("deviceId")
    private String deviceId;
    // 라즈베리파이 이름
    @SerializedName("deviceName")
    private String deviceName;

    @SerializedName("regSensors")
    private ArrayList<Regsensors> regSensors;

    @SerializedName("unregSensors")
    private ArrayList<Regsensors> unregSensors;

    @SerializedName("sensors")
    private ArrayList<Sensors> sensors;

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

    public ArrayList<Regsensors> getRegSensors() {
        return regSensors;
    }

    public void setRegSensors(ArrayList<Regsensors> regSensors) {
        this.regSensors = regSensors;
    }

    public ArrayList<Regsensors> getUnregSensors() {
        return unregSensors;
    }

    public void setUnregSensors(ArrayList<Regsensors> unregSensors) {
        this.unregSensors = unregSensors;
    }

    public ArrayList<Sensors> getSensors() {
        return sensors;
    }

    public void setSensors(ArrayList<Sensors> sensors) {
        this.sensors = sensors;
    }
}
