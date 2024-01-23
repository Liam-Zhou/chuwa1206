package com.chuwa.learn.models;

public class ReservedParkingSpace extends ParkingSpace {
    private static final double HOURLY_RATE = 8.0;
    private final double reservationFee;

    public ReservedParkingSpace(int spaceNumber, double reservationFee) {
        super(spaceNumber);
        this.reservationFee = reservationFee;
    }

    @Override
    public double calculateCharge(int hours) {
        return reservationFee + (HOURLY_RATE * hours);
    }
}