package org.example;

public class ParkingSpot {
    private String number;
    private ParkingSpotType parkingSpotType;
    private VehicleType vehicleType= null;

    public void assign_vehicle(VehicleType vt){
        vehicleType = vt;
    }

    public void remove_vehicle(){
        vehicleType = null;
    }
}
