package kr.ac.kopo.hdyw0w.sixthsensor.item;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DeviceItem {

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private DeviceData data;

    @SerializedName("token")
    private String token;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DeviceData getData() {
        return data;
    }

    public void setData(DeviceData data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ArrayList<Regsensors> getUnregSensors() {
        return data.getDevice().getUnregSensors();
    }

    public ArrayList<Regsensors> getRegSensors() {
        return data.getDevice().getRegSensors();
    }

    public ArrayList<Regsensors> getregSensors(){
        return data.getDevice().getUnregSensors();
    }

}

class DeviceData {

    @SerializedName("device")
    private Device device;

    public kr.ac.kopo.hdyw0w.sixthsensor.item.Device getDevice() {
        return device;
    }

    public void setDevice(kr.ac.kopo.hdyw0w.sixthsensor.item.Device device) {
        this.device = device;
    }
}

class Device {

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
}


