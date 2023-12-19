package ParkingLot;

public class Vehicle {
    private String license;
    private VehicleType type;

    public Vehicle(String license, VehicleType type) {
        this.license = license;
        this.type = type;
    }

    public String getLicensePlate() {
        return license;
    }

    public VehicleType getType() {
        return type;
    }
}

