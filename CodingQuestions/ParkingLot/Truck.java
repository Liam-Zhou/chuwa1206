package ParkingLot;

public class Truck extends Vehicle{
    @Override
    public VehicleSize getSize() {
        return VehicleSize.LARGE;
    }
}
