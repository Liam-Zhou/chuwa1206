package parkinglot;

import vehicle.Vehicle;
import vehicle.VehicleSize;

public abstract class ParkingSpace {

    private final VehicleSize size;
    private Vehicle occupant;

    public ParkingSpace(VehicleSize size) {
        this.size = size;
        this.occupant = null;
    }

    public VehicleSize getSize() {
        return size;
    }

    public boolean isVacant() {
        return occupant == null;
    }

    public void park(Vehicle vehicle) {
        this.occupant = vehicle;
    }

    public void vacate() {
        this.occupant = null;
    }

    abstract public boolean canPark(VehicleSize size);
}
