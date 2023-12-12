public class ParkingSpot {
    private Vehicle vehicle;
    private final int spotNumber;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void removeVehicle() {
        this.vehicle = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}
