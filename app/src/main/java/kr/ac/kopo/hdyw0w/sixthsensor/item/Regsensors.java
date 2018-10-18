package kr.ac.kopo.hdyw0w.sixthsensor.item;

import com.google.gson.annotations.SerializedName;

/**
 * Created by a6614 on 2018-10-18.
 */

public class Regsensors {

    // 아두이노 ID
    @SerializedName("sensorId")
    private String sensorId;
    // 아두이노 이름
    @SerializedName("sensorName")
    private String sensorName;

    @SerializedName("sensorType")
    private String sensorType;

    // 센서 범위
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

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public int getMeasRange() {
        return measRange;
    }

    public void setMeasRange(int measRange) {
        this.measRange = measRange;
    }
}
