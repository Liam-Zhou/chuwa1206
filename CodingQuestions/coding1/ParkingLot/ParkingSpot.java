class ParkingSpot {
    private Vehicle vehicle;
    private final int spotNumber;
    private final VehicleSize size;

    public ParkingSpot(int spotNumber, VehicleSize size) {
        this.spotNumber = spotNumber;
        this.size = size;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (this.vehicle == null && this.size.ordinal() >= vehicle.getSize().ordinal()) {
            this.vehicle = vehicle;
            return true;
        }
        return false;
    }

    public void removeVehicle() {
        this.vehicle = null;
    }

    public boolean isAvailable() {
        return this.vehicle == null;
    }
}
