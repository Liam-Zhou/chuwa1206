package coding1.parkingLot2;

import java.util.List;

public class ParkingLot {
    public static final int NUM_OF_LEVELS = 5;
    private Level[] levels;

    public ParkingLot() {
        this.levels = new Level[NUM_OF_LEVELS];
        for (int i = 0; i < this.levels.length; i++) {
            this.levels[i] = new Level(i + 1);
        }
    }
    public boolean canParkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (!level.canParkVehicle(vehicle).isEmpty()) {
                return  true;
            }
        }
        return false;
    }
    public void vehicleParking(Vehicle vehicle) {
        for (Level level : levels) {
            List<ParkingSpot> spots = level.canParkVehicle(vehicle);
            if (!spots.isEmpty()) {
                level.parkVehicle(vehicle, spots);
                return;
            }
        }
    }
    public void vehicleDeparture(Vehicle vehicle) {
        vehicle.departureSpot();
    }
}
