package com.chuwa.learn.models;

public class Vehicle {
    private final String licensePlate;
    private final String vehicleType;
    private final String color;
    private final String make;

    public Vehicle(String licensePlate, String vehicleType, String color, String make) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.color = color;
        this.make = make;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public String getMake() {
        return make;
    }
}


