package ParkingLot;

public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot(15);

        Car car1 = new Car("NY17823");
        Truck truck1 = new Truck("WA43Z456");
        Bicycle bicycle1 = new Bicycle("CA789sd");
        Motorcycle motorcycle1 = new Motorcycle("PQ45012");
        Bus bus1 = new Bus("Mini4345");

        // Park vehicles
        System.out.println("Parking car: " + parkingLot.parkVehicle(car1));
        System.out.println("Parking truck: " + parkingLot.parkVehicle(truck1));
        System.out.println("Parking bicycle: " + parkingLot.parkVehicle(bicycle1));
        System.out.println("Parking motorcycle: " + parkingLot.parkVehicle(motorcycle1));
        System.out.println("Parking bus: " + parkingLot.parkVehicle(bus1));

        // Vacate a spot
        parkingLot.checkStatus(1);


    }
}