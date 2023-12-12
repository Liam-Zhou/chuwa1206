package coding1.parkingLot2;

public class Bus extends Vehicle{

    public Bus() {
        super(VehicleSize.Large, 5);
    }

    @Override
    public boolean canFitInSpot(ParkingSpot parkingSpot) {
        return VehicleSize.Large == parkingSpot.getSpotSize();
    }
}
