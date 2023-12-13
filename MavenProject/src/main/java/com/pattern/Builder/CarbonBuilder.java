package com.pattern.Builder;

public class CarbonBuilder extends Builder{
    public void buildFrame() {
        bike.setFrame("Carbon Frame");
    }

    public void buildSeat() {
        bike.setSeat("Carbon Seat");
    }

    public void buildTire() {
        bike.setTire("Carbon Tire");
    }

    public Bike createBike() {
        return bike;
    }
}
