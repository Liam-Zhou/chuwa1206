public class TestParking {

    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getParkingLot();

        parkingLot.initializeParkingSpots(10, 10);

        Vehicle vehicle = new Vehicle("ve12", VehicleSize.TWOWHEELER);

        Ticket ticket = parkingLot.park(vehicle);
        System.out.println(ticket);

        Vehicle vehicle2 = new Vehicle("ve13", VehicleSize.TWOWHEELER);

        Ticket ticket2 = parkingLot.park(vehicle2);
        System.out.println(ticket2);

    }

}