package ParkingLot;

public class Car extends Vehicle{
    @Override
    public VehicleSize getSize() {
        return VehicleSize.SMALL;
    }
}
