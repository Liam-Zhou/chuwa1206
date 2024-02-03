package com.chuwa.learn;

public class Vehicle {
    public int wheels;

    public Vehicle(int wheels) {
        this.wheels = wheels;
    }

    public void move() {
        System.out.println("Vehicle with " + wheels + " wheels is moving");
    }
}
