package kr.ac.kopo.hdyw0w.sixthsensor.item;

import com.google.gson.annotations.SerializedName;

public class PlaceItem {

    @SerializedName("PlaceName")
    private String PlaceName;

    @SerializedName("status")
    private String status;

    public void setPlacename(String PlaceName)
    { this.PlaceName = PlaceName;}

    public String getPlacename(){
        return PlaceName;
    }

    public void setStatus(String status)
    { this.status = status;}

    public String getStatus(){
        return PlaceName;
    }

}
