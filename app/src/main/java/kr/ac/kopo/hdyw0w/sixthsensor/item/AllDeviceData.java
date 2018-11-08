package kr.ac.kopo.hdyw0w.sixthsensor.item;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AllDeviceData {

    @SerializedName("devices")
    public ArrayList<Devices> devices;

    public ArrayList<Devices> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<Devices> devices) {
        this.devices = devices;
    }
}
