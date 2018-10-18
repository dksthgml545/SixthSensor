//package kr.ac.kopo.hdyw0w.sixthsensor.item;
//
//import com.google.gson.annotations.SerializedName;
//
//import java.util.ArrayList;
//
//import kr.ac.kopo.hdyw0w.sixthsensor.RegDevice;
//
//public class RaspberryItem {
//
//    @SerializedName("status")
//    private String status;
//
//    @SerializedName("data")
//    private Raspdata data;
//
//    public String getStatus() {return status;}
//    public void setStatus(String status) {this.status = status;}
//
//    public Raspdata getData() {
//        return data;
//    }
//
//    public void setData(Raspdata data) {
//        this.data = data;
//    }
//
//    public ArrayList<RegDevice> getUnregDevice() {
//        return data.getUnregDevice();
//    }
//
//}
//
//class Raspdata {
//
//    @SerializedName("deviceId")
//    private String deviceId;
//
//    public String getDeviceId() {return deviceId;}
//    public void setDeviceId(String deviceId) {this.deviceId = deviceId;}
//
//    @SerializedName("regDevice")
//    private ArrayList<RegDevice> regDevice;
//
//    @SerializedName("unregDevice")
//    private ArrayList<RegDevice> unregDevice;
//
//    public ArrayList<RegDevice> getRegDevice() {
//        return regDevice;
//    }
//
//    public void setRegDevice(ArrayList<RegDevice> regDevice) {
//        this.regDevice = regDevice;
//    }
//
//    public ArrayList<RegDevice> getUnregDevice() {
//        return unregDevice;
//    }
//
//    public void setUnregDevice(ArrayList<RegDevice> unregDevice) {
//        this.unregDevice = unregDevice;
//    }
//}
