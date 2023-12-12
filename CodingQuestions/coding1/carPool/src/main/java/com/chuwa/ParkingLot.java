package com.chuwa;
import java.util.*;

public class ParkingLot {
    private List<ParkingSpot> spots;
    public ParkingLot(int numOfSpots){
        spots = new ArrayList<ParkingSpot>();
        for(int i = 1; i <= numOfSpots; i++){
            spots.add(new ParkingSpot(i));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                return spot.park(vehicle);
            }
        }
        System.out.println("Parking lot is full.");
        return false;
    }

    public boolean leaveVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getVehicle().equals(vehicle)) {
                return spot.leave();
            }
        }
        System.out.println("Vehicle not found.");
        return false;
    }

}
