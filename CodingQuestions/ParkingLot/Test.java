package ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3, 50);
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        for (int i = 0; i < 151; i++) {
            if (i % 3 == 0) {
                vehicleList.add(new Car());
            } else if (i % 3 == 1) {
                vehicleList.add(new MPV());
            } else {
                vehicleList.add(new Truck());
            }
        }

        //parking
        for (int i = 0; i < vehicleList.size(); i++) {
            Vehicle v = vehicleList.get(i);
            System.out.println("Current vehicle size: " + v.getSize());
            System.out.println("Has available spots? " + parkingLot.hasSpots(v));
            System.out.println("Parking success: " + parkingLot.park(v) + "\n");
        }
        System.out.println("--------------------------------------------");
        for (int i = 0; i < vehicleList.size(); i++) {
            Vehicle v = vehicleList.get(i);
            System.out.println("Current vehicle size: " + v.getSize());
            System.out.println("Leaving success: " + parkingLot.leave(v) + "\n");
        }
    }
}
