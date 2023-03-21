package com.sg.propertyWebsite.entities;

import java.util.ArrayList;
import java.util.List;

public class Amenity {
    private int ammenitiesID;
    private String tv;
    private String hotTub;
    private String oven;
    private String microwave;
    private String fridge;
    private String swimmingPool;

    public void setAmmenitiesID(int ammenitiesID) {
        this.ammenitiesID = ammenitiesID;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public void setHotTub(String hotTub) {
        this.hotTub = hotTub;
    }

    public void setOven(String oven) {
        this.oven = oven;
    }

    public void setMicrowave(String microwave) {
        this.microwave = microwave;
    }

    public void setFridge(String fridge) {
        this.fridge = fridge;
    }

    public void setSwimmingPool(String swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    public List<String> getAmmenities(){
        List<String> amenitiesList = new ArrayList<>();
        if(this.tv != null){
            amenitiesList.add("TV");
        }
        if(this.fridge!= null){
            amenitiesList.add("Fridge");
        }
        if(this.hotTub!= null){
            amenitiesList.add("Hot Tub");
        }
        if(this.oven!= null){
            amenitiesList.add("Oven");
        }
        if(this.microwave!= null){
            amenitiesList.add("Microwave");
        }
        if(this.swimmingPool!= null){
            amenitiesList.add("Swimming Pool");
        }
        return amenitiesList;
    }
}
