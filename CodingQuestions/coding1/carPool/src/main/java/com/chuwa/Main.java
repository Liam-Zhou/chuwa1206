package com.chuwa;

public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot(100);
        Vehicle car = new Vehicle("chuwa", VehicleType.SMALLCAR);
        parkingLot.parkVehicle(car);

    }
}