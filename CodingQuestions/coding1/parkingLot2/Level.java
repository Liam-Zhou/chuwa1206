package coding1.parkingLot2;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private static final int NUM_OF_ROW = 5, SPOTS_PER_ROW = 10;
    private int floor;
    private ParkingSpot[][] spots;
    private int availableSpots;

    public Level(int floor) {
        this.floor = floor;
        spots = new ParkingSpot[NUM_OF_ROW][SPOTS_PER_ROW];//TODO: spots should be initialized base on the design of parking lot
//        for (int i = 0; i < NUM_OF_ROW; i++) {
//            for (int j = 0; j < SPOTS_PER_ROW; j++) {
//                spots[i][j] = new ParkingSpot(VehicleSize.Large, i * SPOTS_PER_ROW + j, 5, this);
//            }
//        }
        this.availableSpots = NUM_OF_ROW * SPOTS_PER_ROW;
    }

    public List<ParkingSpot> canParkVehicle(Vehicle vehicle) {
        for (int i = 0; i < NUM_OF_ROW; i++) {
            List<ParkingSpot> spots = canParkVehicleInRow(i, vehicle);
            if (!spots.isEmpty()) {
                return spots;
            }
        }
        return new ArrayList<>();
    }
    public List<ParkingSpot> canParkVehicleInRow (int rowIdx, Vehicle vehicle) {
        ParkingSpot[] row = spots[rowIdx];
        int spotsNeeded = vehicle.getSpotsNeeded(), count = 0;
        List<ParkingSpot> spots = new ArrayList<ParkingSpot>();

        for (int i = 0; i < SPOTS_PER_ROW; i++) {
            ParkingSpot spot = row[i];
            if (spot.isAvailable() && vehicle.canFitInSpot(spot)) {
                count++;
                spots.add(spot);
            } else {
                count = 0;
                spots.clear();
            }
            if (count == spotsNeeded) {
                return spots;
            }
        }
        return new ArrayList<ParkingSpot>();
    }
    public void parkVehicle(Vehicle vehicle, List<ParkingSpot> spots) {
        vehicle.parkInSpot(this, spots);
        this.availableSpots -= vehicle.getSpotsNeeded();
    }
    public void departureVehicle(Vehicle vehicle) {
        this.availableSpots += vehicle.getSpotsNeeded();
    }

    public int getFloor() {
        return floor;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }
}
