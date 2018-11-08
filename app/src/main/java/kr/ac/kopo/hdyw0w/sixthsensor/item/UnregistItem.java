package kr.ac.kopo.hdyw0w.sixthsensor.item;

import java.io.Serializable;

public class UnregistItem implements Serializable {

    private int drawableId;
    private String arduinoId;
    private int range;
    private String arduinoName;

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public String getArduinoId() {
        return arduinoId;
    }

    public void setArduinoId(String arduinoId) {
        this.arduinoId = arduinoId;
    }

    public UnregistItem(int drawableId, String arduinoId) {
        this.drawableId = drawableId;
        this.arduinoId = arduinoId;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getArduinoName() {
        return arduinoName;
    }

    public void setArduinoName(String arduinoName) {
        this.arduinoName = arduinoName;
    }
}