package com.chuwa;

public class ParkingSpot {
    private final int spotNumber;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSpot(int spotNumber){
        this.spotNumber = spotNumber;
        this.isOccupied = false;
    }

    public boolean park(Vehicle vehicle){
        if(!isOccupied){
            this.vehicle = vehicle;
            this.isOccupied = true;
            return true;
        }
        return false;
    }

    public boolean leave(){
        if(isOccupied){
            this.vehicle = null;
            this.isOccupied = false;
            return true;
        }
        return false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

}
