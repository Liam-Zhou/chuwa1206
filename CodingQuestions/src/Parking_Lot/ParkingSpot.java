package Parking_Lot;

public class ParkingSpot {
    private int number;
    private Type spotType;
    private boolean isAvailable;
    private Vehicle vehicle;

    public ParkingSpot(int number, Type type) {
        this.number = number;
        this.spotType = type;
    }

    public int getNumber() {
        return number;
    }

    public Type getType() {
        return spotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
