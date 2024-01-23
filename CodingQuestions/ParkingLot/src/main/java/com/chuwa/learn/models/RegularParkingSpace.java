package com.chuwa.learn.models;

public class RegularParkingSpace extends ParkingSpace {
    private static final double HOURLY_RATE = 5.0;

    public RegularParkingSpace(int spaceNumber) {
        super(spaceNumber);
    }

    @Override
    public double calculateCharge(int hours) {
        return HOURLY_RATE * hours;
    }
}