package kr.ac.kopo.hdyw0w.sixthsensor.item;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AddDeviceItem {

    @SerializedName("deviceName")
    private String deviceName;

    @SerializedName("sensors")
    public ArrayList<Sensors> sensors;

    @SerializedName("status")
    private String status;


    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public ArrayList<kr.ac.kopo.hdyw0w.sixthsensor.item.Sensors> getSensors() {
        return sensors;
    }

    public void setSensors(ArrayList<kr.ac.kopo.hdyw0w.sixthsensor.item.Sensors> Sensors) {
        this.sensors = Sensors;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSensorId() { return sensors.get(0).getSensorId();}
    public String getSensorName() { return sensors.get(0).getSensorName();}
    public int getMeasRange() { return sensors.get(0).getMeasRange();}
}

class Sensors {

    @SerializedName("sensorId")
    private String sensorId;

    @SerializedName("sensorName")
    private String sensorName;

    @SerializedName("measRange")
    private int measRange;

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

    public int getMeasRange() {
        return measRange;
    }

    public void setMeasRange(int measRange) {
        this.measRange = measRange;
    }
}
