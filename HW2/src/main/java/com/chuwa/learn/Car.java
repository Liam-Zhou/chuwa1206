package com.chuwa.learn;

public class Car extends Vehicle {
    private String brand;

    public Car(int wheels, String brand) {
        super(wheels);
        this.brand = brand;
    }

    public void honk() {
        System.out.println("Car " + brand + " is honking");
    }

}