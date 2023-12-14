package com.java.builder;

public class MobileBuilder extends Builder{

    @Override
    public void buildFrame() {
        bike.setFrame("Carbon");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Leather");
    }

    @Override
    public Bike buildBike() {
        return bike;
    }
}
