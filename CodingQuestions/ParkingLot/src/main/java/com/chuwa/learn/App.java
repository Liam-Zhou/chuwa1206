package com.chuwa.learn;

import com.chuwa.learn.models.Vehicle;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5, 5);

        Vehicle car1 = new Vehicle("ABC123", "Car", "Blue", "Toyota");
        Vehicle car2 = new Vehicle("XYZ789", "Car", "Red", "Honda");
        Vehicle motorcycle = new Vehicle("DEF456", "Motorcycle", "Black", "Harley Davidson");

        parkingLot.parkVehicle(car1, 1);
        parkingLot.parkVehicle(car2, 6);
        parkingLot.parkVehicle(motorcycle, 3);

        parkingLot.printParkingStatus();

        int hoursParked = 3;
        double chargeForCar1 = parkingLot.vacateSpace(1, hoursParked);
        System.out.println("Charge for Car1: $" + chargeForCar1);

        parkingLot.printParkingStatus();
    }
}
