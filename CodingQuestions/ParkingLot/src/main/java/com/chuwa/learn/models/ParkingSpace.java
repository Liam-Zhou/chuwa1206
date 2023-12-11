package com.chuwa.learn.models;


public abstract class ParkingSpace {
    private final int spaceNumber;
    private boolean occupied;
    private Vehicle parkedVehicle;

    public ParkingSpace(int spaceNumber) {
        this.spaceNumber = spaceNumber;
        this.occupied = false;
    }

    public abstract double calculateCharge(int hours);

    public boolean isOccupied() {
        return occupied;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.occupied = true;
    }

    public void vacateSpace() {
        this.parkedVehicle = null;
        this.occupied = false;
    }

    public int getSpaceNumber() {
        return spaceNumber;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void printStatus() {
        System.out.println("Space " + spaceNumber + ": " + (occupied ? parkedVehicle.getLicensePlate() + " (" + parkedVehicle.getVehicleType() + ")" : "Empty"));
    }
}
