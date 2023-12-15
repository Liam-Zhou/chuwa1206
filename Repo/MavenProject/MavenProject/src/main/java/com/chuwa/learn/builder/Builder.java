package com.chuwa.learn.builder;

public abstract class Builder {
    protected Bike bike = new Bike();

    public abstract void buildFrame();

    public abstract Bike createBike();
}
