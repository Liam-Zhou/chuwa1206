public class ParkingLot {
    private ParkingSpot[] spots;

    public ParkingLot(int numberOfSpots) {
        spots = new ParkingSpot[numberOfSpots];
        for (int i = 0; i < numberOfSpots; i++) {
            spots[i] = new ParkingSpot(i);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                spot.parkVehicle(vehicle);
                System.out.println("Vehicle parked at spot " + spot.getSpotNumber());
                return true;
            }
        }
        System.out.println("Parking lot is full.");
        return false;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isAvailable() && spot.getVehicle().getLicensePlate().equals(vehicle.getLicensePlate())) {
                spot.removeVehicle();
                System.out.println("Vehicle removed from spot " + spot.getSpotNumber());
                return true;
            }
        }
        System.out.println("Vehicle not found.");
        return false;
    }
}
