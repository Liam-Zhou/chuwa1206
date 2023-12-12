package ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final List<ParkingSpot> spots;

    public Level(int numOfSpots) {
        this.spots = new ArrayList<ParkingSpot>(numOfSpots);
        int i = 0;
        for (; i < numOfSpots * 2 / 3; i++) {
            spots.add(new ParkingSpot(VehicleSize.SMALL));
        }
        for (; i < numOfSpots * 8 / 9; i++) {
            spots.add(new ParkingSpot(VehicleSize.MEDIUM));
        }
        for (; i < numOfSpots; i++) {
            spots.add(new ParkingSpot(VehicleSize.LARGE));
        }
    }

    public boolean hasSpot(Vehicle v) {
        for (ParkingSpot p : spots) {
            if (p.fit(v)) {
                return true;
            }
        }
        return false;
    }

    public boolean park(Vehicle v) {
        for (ParkingSpot p : spots) {
            if (p.fit(v)) {
                p.park(v);
                return true;
            }
        }
        return false;
    }

    public boolean leave(Vehicle v) {
        for (ParkingSpot p : spots) {
            if (p.getVehicle() == v) {
                p.leave(v);
                return true;
            }
        }
        return false;
    }
}
