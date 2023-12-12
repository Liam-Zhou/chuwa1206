package com.chuwa.learn;

import com.chuwa.learn.models.ParkingSpace;
import com.chuwa.learn.models.RegularParkingSpace;
import com.chuwa.learn.models.ReservedParkingSpace;
import com.chuwa.learn.models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<Integer, ParkingSpace> parkingSpaces;

    public ParkingLot(int regularCapacity, int reservedCapacity) {
        parkingSpaces = new HashMap<>();

        for (int i = 1; i <= regularCapacity; i++) {
            parkingSpaces.put(i, new RegularParkingSpace(i));
        }

        for (int i = regularCapacity + 1; i <= regularCapacity + reservedCapacity; i++) {
            parkingSpaces.put(i, new ReservedParkingSpace(i, 10.0)); // Example reservation fee
        }
    }

    public boolean parkVehicle(Vehicle vehicle, int spaceNumber) {
        ParkingSpace space = parkingSpaces.get(spaceNumber);
        if (space != null && !space.isOccupied()) {
            space.parkVehicle(vehicle);
            return true; // Vehicle parked successfully
        }
        return false; // Invalid space or space is occupied
    }

    public double vacateSpace(int spaceNumber, int hours) {
        ParkingSpace space = parkingSpaces.get(spaceNumber);
        if (space != null && space.isOccupied()) {
            space.vacateSpace();
            return space.calculateCharge(hours); // Return the calculated charge
        }
        return 0.0; // Invalid space or space is empty
    }

    public void printParkingStatus() {
        System.out.println("Parking Lot Status:");
        for (ParkingSpace space : parkingSpaces.values()) {
            space.printStatus();
        }
    }
}