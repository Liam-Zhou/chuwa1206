public class Car extends Vehicle {
    public Car(String licPlate) {
        this.licensePlate = licPlate;
        spotsNeeded = 1;
        size = VehicleSize.Car;
    }
    public boolean canFitinSpot(ParkingSpot spot) {
        return spot.getSpotSize() == size;
    }
}
