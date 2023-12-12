import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingLot {

    private static ParkingLot parkingLot;
    private final List<Spot> twoWheelerSpots;
    private final List<Spot> fourWheelerSpots;

    private ParkingLot() {
        this.twoWheelerSpots = new ArrayList<>();
        this.fourWheelerSpots = new ArrayList<>();
    }

    public static ParkingLot getParkingLot() {
        if (parkingLot == null)
            parkingLot = new ParkingLot();
        return parkingLot;
    }

    public boolean initializeParkingSpots(int numberOfTwoWheelerParkingSpots, int numberOfFourWheelerParkingSpots) {

        for (int i = 1; i <= numberOfTwoWheelerParkingSpots; i++) {
            twoWheelerSpots.add(new Spot(i));
        }

        System.out.printf("Created a two wheeler parking lot with %s slots %n", numberOfTwoWheelerParkingSpots);

        for (int i = 1; i <= numberOfFourWheelerParkingSpots; i++) {
            fourWheelerSpots.add(new Spot(i));
        }

        System.out.printf("Created a four wheeler parking lot with %s slots %n", numberOfFourWheelerParkingSpots);
        return true;
    }

    public Ticket park(Vehicle vehicle) {
        Spot nextAvailableSpot;
        if (vehicle.getVehicleSize().equals(VehicleSize.FOURWHEELER)) {
            nextAvailableSpot = getNextAvailableFourWheelerSpot();
        } else {
            nextAvailableSpot = getNextAvailableTwoWheelerSpot();
        }
        nextAvailableSpot.occupySlot(vehicle);
        System.out.printf("Allocated slot number: %d \n", nextAvailableSpot.getSlotNumber());
        Ticket ticket = new Ticket(nextAvailableSpot.getSlotNumber(), vehicle.getVehicleNumber(),
                vehicle.getVehicleSize(), new Date());
        return ticket;
    }

    private Spot getNextAvailableFourWheelerSpot() {
        for (Spot spot : fourWheelerSpots) {
            if (spot.isEmpty()) {
                return spot;
            }
        }
        return null;
    }

    private Spot getNextAvailableTwoWheelerSpot() {
        for (Spot spot : twoWheelerSpots) {
            if (spot.isEmpty()) {
                return spot;
            }
        }
        return null;
    }
}
