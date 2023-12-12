package ParkingLot;

public class ParkingSpot {
    private final VehicleSize size;
    private Vehicle currentVehicle;
    public ParkingSpot(VehicleSize size) {
        this.size = size;
    }

    public boolean fit(Vehicle v) {
        return currentVehicle == null && v.getSize().getSize() <= size.getSize();
    }

    public void park(Vehicle v) {
        if (fit(v)) {
            this.currentVehicle = v;
        }
    }

    public void leave(Vehicle v) {
        currentVehicle = null;
    }

    public Vehicle getVehicle() {
        return currentVehicle;
    }
}
