package com.chuwa.vehicles;

public abstract class Vehicles{
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlate() {
        return this.plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    private String type;
    private String plate;
}

