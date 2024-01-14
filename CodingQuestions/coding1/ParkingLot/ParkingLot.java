class ParkingLot {
    private ParkingSpot[] spots;

    public ParkingLot(int numSmall, int numMedium, int numLarge) {
        int totalSpots = numSmall + numMedium + numLarge;
        spots = new ParkingSpot[totalSpots];
        for (int i = 0; i < totalSpots; i++) {
            VehicleSize size = i < numSmall ? VehicleSize.SMALL : i < numSmall + numMedium ? VehicleSize.MEDIUM : VehicleSize.LARGE;
            spots[i] = new ParkingSpot(i, size);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.parkVehicle(vehicle)) {
                vehicle.startParking(60); // Example duration
                return true;
            }
        }
        return false;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.vehicle == vehicle) {
                spot.removeVehicle();
                vehicle.endParking();
                return true;
            }
        }
        return false;
    }
}
