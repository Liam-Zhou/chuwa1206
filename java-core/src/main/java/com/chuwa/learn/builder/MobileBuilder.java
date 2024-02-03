package com.chuwa.learn.builder;

public class MobileBuilder extends Builder{

    @Override
    public void buildFrame() {
        bike.setFrame("Steel");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Leather");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
