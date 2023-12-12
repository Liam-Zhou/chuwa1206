package ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
        private List<Spot> spots;

        public ParkingLot(int capacity) {
            spots = new ArrayList<>(capacity);
            for (int i = 1; i <= capacity; i++) {
                spots.add(new Spot(i));
            }
        }

        public boolean parkVehicle(Vehicle vehicle) {
            for (Spot spot : spots) {
                if (!spot.isOccupied()) {
                    spot.parkVehicle(vehicle);
                    return true;
                }
            }
            return false; // Parking lot is full
        }

        public void checkStatus(int spotNumber) {
            for (Spot spot : spots) {
                if (spot.getSpotNumber() == spotNumber && spot.isOccupied()) {
                    spot.closeSpot();
                    System.out.println("Spot " + spotNumber + " closed.");
                    return;
                }
            }
            System.out.println("Spot " + spotNumber + " is not occupied.");
        }
    }


