public class ParkingLotSystem {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10); // a parking lot with 10 spots

        Vehicle car = new Car("CAR123");
        Vehicle motorcycle = new Motorcycle("BIKE456");

        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(motorcycle);

    }
}
