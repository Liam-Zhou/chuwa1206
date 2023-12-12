package coding1.parkingLot2;

public class Motorcycle extends Vehicle{
    public Motorcycle() {
        super(VehicleSize.Motorcycle, 1);
    }
    @Override
    public boolean canFitInSpot(ParkingSpot parkingSpot) {
        return VehicleSize.Large == parkingSpot.getSpotSize()
                || VehicleSize.Compact == parkingSpot.getSpotSize()
                || VehicleSize.Motorcycle == parkingSpot.getSpotSize();
    }
}
