public class Motorcycle extends Vehicle {
    public Motorcycle(String licPlate) {
        this.licensePlate = licPlate;
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }

    public boolean canFitinSpot(ParkingSpot spot) {
        return spot.getSpotSize() == size || spot.getSpotSize() == VehicleSize.Car;
    }
}
