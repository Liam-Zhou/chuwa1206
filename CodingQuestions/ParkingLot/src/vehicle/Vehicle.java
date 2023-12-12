package vehicle;

public abstract class Vehicle {

    private final VehicleSize size;
    private final String licensePlate;

    public Vehicle(VehicleSize size, String licensePlate) {
        this.size = size;
        this.licensePlate = licensePlate;
    }

    public VehicleSize getSize() {
        return size;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
