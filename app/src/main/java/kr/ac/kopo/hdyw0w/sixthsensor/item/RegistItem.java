package kr.ac.kopo.hdyw0w.sixthsensor.item;

public class RegistItem {

    private int drawableId;
    private String arduinoName;

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public String getArduinoName() {
        return arduinoName;
    }

    public void setArduinoName(String arduinoName) {
        this.arduinoName = arduinoName;
    }

    public RegistItem(int drawableId, String arduinoName) {
        this.drawableId = drawableId;
        this.arduinoName = arduinoName;
    }
}
