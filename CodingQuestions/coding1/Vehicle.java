public abstract class Vehicle {
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleSize size;

    public int getSpotsNeeded() {
        return spotsNeeded;
    }
    public VehicleSize getSize() {
        return size;
    }

    public abstract boolean canFitinSpot(ParkingSpot spot);
}

