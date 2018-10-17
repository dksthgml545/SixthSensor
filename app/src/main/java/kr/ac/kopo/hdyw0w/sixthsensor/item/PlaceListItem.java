package kr.ac.kopo.hdyw0w.sixthsensor.item;

public class PlaceListItem {

    private int drawableId;
    private String placeName;
    private int registCount;
    private int fullCount;

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

    public PlaceListItem(int drawableId, String placeName, int registCount, int fullCount) {
        this.drawableId = drawableId;
        this.placeName = placeName;
        this.registCount = registCount;
        this.fullCount = fullCount;
    }
}
