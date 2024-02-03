package com.chuwa.learn.builder;

public class ofoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("plastic");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Cloth");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
