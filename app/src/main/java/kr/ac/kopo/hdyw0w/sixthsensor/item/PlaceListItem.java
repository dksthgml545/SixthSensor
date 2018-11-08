package kr.ac.kopo.hdyw0w.sixthsensor.item;

import java.io.Serializable;

public class PlaceListItem implements Serializable {

    private String deviceId;
    private int drawableId;
    private String placeName;
    private int registCount;
    private int fullCount;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public int getRegistCount() {
        return registCount;
    }

    public void setRegistCount(int registCount) {
        this.registCount = registCount;
    }

    public int getFullCount() {
        return fullCount;
    }

    public void setFullCount(int fullCount) {
        this.fullCount = fullCount;
    }

    public PlaceListItem(int drawableId, String deviceId, String placeName, int registCount, int fullCount) {
        this.deviceId = deviceId;
        this.drawableId = drawableId;
        this.placeName = placeName;
        this.registCount = registCount;
        this.fullCount = fullCount;
    }
}
