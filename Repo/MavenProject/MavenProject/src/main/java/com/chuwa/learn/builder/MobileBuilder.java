package com.chuwa.learn.builder;

public class MobileBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("aaa");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
