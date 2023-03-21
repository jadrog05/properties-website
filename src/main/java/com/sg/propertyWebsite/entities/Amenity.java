package com.sg.propertyWebsite.entities;

import java.util.ArrayList;
import java.util.List;

public class Amenity {
    private int ammenitiesID;
    private boolean tv;
    private boolean hotTub;
    private boolean oven;
    private boolean microwave;
    private boolean fridge;
    private boolean swimmingPool;

    public void setAmmenitiesID(int ammenitiesID) {
        this.ammenitiesID = ammenitiesID;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public void setHotTub(boolean hotTub) {
        this.hotTub = hotTub;
    }

    public void setOven(boolean oven) {
        this.oven = oven;
    }

    public void setMicrowave(boolean microwave) {
        this.microwave = microwave;
    }

    public void setFridge(boolean fridge) {
        this.fridge = fridge;
    }

    public void setSwimmingPool(boolean swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    public List<String> getAmmenities(){
        List<String> amenitiesList = new ArrayList<>();
        if(this.tv){
            amenitiesList.add("TV");
        }
        if(this.fridge){
            amenitiesList.add("Fridge");
        }
        if(this.hotTub){
            amenitiesList.add("Hot Tub");
        }
        if(this.oven){
            amenitiesList.add("Oven");
        }
        if(this.microwave){
            amenitiesList.add("Microwave");
        }
        if(this.swimmingPool){
            amenitiesList.add("Swimming Pool");
        }
        return amenitiesList;
    }
}
