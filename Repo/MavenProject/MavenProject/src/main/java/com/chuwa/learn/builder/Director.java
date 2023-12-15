package com.chuwa.learn.builder;

public class Director {
    private Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }
    public Bike construct(){
        builder.buildFrame();
        return builder.createBike();
    }
}
