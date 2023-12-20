package com.java.builder;

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("Wood");
    }

    @Override
    public void buildSeat() {
        bike.setFrame("Plastic");
    }

    @Override
    public Bike buildBike() {
        return bike;
    }
}
