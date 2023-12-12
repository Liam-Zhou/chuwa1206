public class Parking {
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(2);
        Car car1 = new Car("1");
        Motorcycle m1 = new Motorcycle("2");
        Car car2 = new Car("3");
        Motorcycle m2 = new Motorcycle("4");
        Car car3 = new Car("5");

        pl.parkVehicle(car1);
        pl.parkVehicle(m1);
        pl.parkVehicle(car2);
        pl.leave(m1, 0);
        pl.parkVehicle(m2);
        pl.parkVehicle(car3);
    }
}
