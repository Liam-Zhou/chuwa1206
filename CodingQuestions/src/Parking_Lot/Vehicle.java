package Parking_Lot;

public class Vehicle {
    private String licensePlate;
    private Type vehicleType;
    private ParkingSpot parkingSpot;

    public Vehicle(String licensePlate, Type vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Type getVehicleType() {
        return vehicleType;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

}
