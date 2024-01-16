public class TestParkingLot {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(5, 5, 2);
        Car car = new Car("ABC123", "Red", "Model S", "Tesla");
        Motorcycle motorcycle = new Motorcycle("XYZ789", "Black", "Ninja", "Kawasaki");

        lot.parkVehicle(car);
        lot.parkVehicle(motorcycle);

        // Simulating vehicle exits
        lot.removeVehicle(car);
        lot.removeVehicle(motorcycle);
    }
}

