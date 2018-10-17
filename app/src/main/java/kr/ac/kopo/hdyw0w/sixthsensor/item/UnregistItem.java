package kr.ac.kopo.hdyw0w.sixthsensor.item;

public class UnregistItem {

    private int drawableId;
    private String arduinoId;

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
}