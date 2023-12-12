package coding1.parkingLot2;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    protected List<ParkingSpot> parkingSpots;
    private VehicleSize vehicleSize;
    private int spotsNeeded;
    private Level parkingLotLevel;

    public Vehicle(VehicleSize vehicleSize, int spotsNeeded) {
        this.parkingSpots = new ArrayList<ParkingSpot>();
        this.vehicleSize = vehicleSize;
        this.spotsNeeded = spotsNeeded;
    }
    public abstract boolean canFitInSpot(ParkingSpot parkingSpot);

    public  void parkInSpot(Level level, List<ParkingSpot> spots) {
        this.parkingLotLevel = level;
        for (ParkingSpot spot : spots) {
            spot.parkVehicle(this);
        }
        this.parkingSpots.addAll(spots);
    }

    public void departureSpot() {
        for (ParkingSpot spot : parkingSpots) {
            spot.removeVehicle();
        }
        this.parkingSpots.clear();
        this.parkingLotLevel.departureVehicle(this);
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }
}
