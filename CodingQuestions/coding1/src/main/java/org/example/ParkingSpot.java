package org.example;
import org.example.VehicleType;
import org.example.Vehicle;


public class ParkingSpot {
    private boolean isOccupied;
    private String spotID;
    private Vehicle vehicle;
    private VehicleType vehicleType;

    public ParkingSpot(String spotID, VehicleType vehicleType) {
        this.spotID = spotID;
        this.vehicleType = vehicleType;
    }

    public String getSpotID() {
        return spotID;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getVehicle() {
        if (isOccupied) {
            return vehicle;
        } else {
            return null;
        }
    }
    public void occupy(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void vacate() {
        isOccupied = false;
    }


}
