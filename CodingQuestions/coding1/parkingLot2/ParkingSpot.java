package coding1.parkingLot2;

public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int spotId, row;
    private Level level;

    public ParkingSpot(VehicleSize spotSize, int spotId, int row, Level level) {
        this.spotSize = spotSize;
        this.spotId = spotId;
        this.row = row;
        this.level = level;
    }
    public boolean isAvailable() {
        return  this.vehicle == null;
    }
    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public void removeVehicle() {
        this.vehicle = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }

    public int getSpotId() {
        return spotId;
    }

    public int getRow() {
        return row;
    }

    public Level getLevel() {
        return level;
    }
}
