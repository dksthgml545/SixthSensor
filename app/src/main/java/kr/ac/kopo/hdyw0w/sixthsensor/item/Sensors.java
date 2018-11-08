package kr.ac.kopo.hdyw0w.sixthsensor.item;

import com.google.gson.annotations.SerializedName;

public class Sensors {

    @SerializedName("sensorIcon")
    private int drawableId;

    @SerializedName("sensorId")
    private String sensorId;

    @SerializedName("sensorName")
    private String sensorName;

    @SerializedName("measRange")
    private int measRange;

    @SerializedName("sensorType")
    private String sensorType;

    @SerializedName("sensorStatus")
    private boolean sensorStatus;

    @SerializedName("createdAt")
    private String createdAt;

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

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

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public boolean isSensorStatus() {
        return sensorStatus;
    }

    public void setSensorStatus(boolean sensorStatus) {
        this.sensorStatus = sensorStatus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Sensors() {
        this.drawableId = drawableId;
        this.sensorId = sensorId;
        this.sensorName = sensorName;
        this.measRange = measRange;
        this.sensorType = sensorType;
        this.sensorStatus = sensorStatus;
        this.createdAt = createdAt;
    }
}
