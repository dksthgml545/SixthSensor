package kr.ac.kopo.hdyw0w.sixthsensor.item;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DeviceItem {

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private DeviceData data;

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

class regSensors {

    @SerializedName("sensorId")
    public String sensorId;

    @SerializedName("sensorName")
    public String sensorName;

    @SerializedName("sensorType")
    public String sensorType;

    @SerializedName("measRange")
    public String measRange;

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getMeasRange() {
        return measRange;
    }

    public void setMeasRange(String measRange) {
        this.measRange = measRange;
    }
}

