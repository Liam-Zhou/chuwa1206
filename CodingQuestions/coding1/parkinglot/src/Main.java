public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        ParkingLot parkingLot = new ParkingLot(10);
        Vehicle vehicle = new Vehicle("A", "SUV");
        Vehicle vehicle1 = new Vehicle("B", "sedan");
        parkingLot.park(1, vehicle);
        parkingLot.park(1, vehicle1);
        parkingLot.unpark(1);
        parkingLot.park(1, vehicle1);
    }
}