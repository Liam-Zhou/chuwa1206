package coding1.parkingLot2;

public class Car extends Vehicle{
    public Car() {
        super(VehicleSize.Compact, 1);
    }
    @Override
    public boolean canFitInSpot(ParkingSpot parkingSpot) {
        return VehicleSize.Large == parkingSpot.getSpotSize()
                || VehicleSize.Compact == parkingSpot.getSpotSize();
    }
}
