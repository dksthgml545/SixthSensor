package kr.ac.kopo.hdyw0w.sixthsensor.item;

public class DfiListItem {
    private int drawableId;
    private String itemName;

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public DfiListItem(int drawableId, String itemName) {
        this.drawableId = drawableId;
        this.itemName = itemName;
    }
}
