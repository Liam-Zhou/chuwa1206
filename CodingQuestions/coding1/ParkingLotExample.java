package CodingQuestions.coding1;

import java.util.ArrayList;
import java.util.List;

enum VehicleType {
    REGULAR, COMPACT, HANDICAPPED
}
//Part-of : Composition(e.g. ParkingSpot --> parking lot)
class ParkingSpot {
    private Integer spotNumber;
    private boolean occupied;
    private VehicleType type;

    public ParkingSpot(Integer spotNumber, VehicleType type) {
        this.spotNumber = spotNumber;
        this.type = type;
        this.occupied = false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void occupy() {
        occupied = true;
    }

    public void vacate() {
        occupied = false;
    }

    public VehicleType getType() {
        return type;
    }
}

class Vehicle {
    private String licensePlate;
    private VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }
}
//Has-a : Aggregation(e.g. ParkingLot --> ParkingSpot)
class ParkingLot {
    private List<ParkingSpot> spots;

    public ParkingLot(int totalSpots) {
        spots = new ArrayList<>(totalSpots);
        initializeParkingSpots(totalSpots);
    }

    private void initializeParkingSpots(int totalSpots) {
        for (int i = 1; i <= totalSpots; i++) {
            VehicleType type = determineSpotType(i);
            spots.add(new ParkingSpot(i, type));
        }
    }

    private VehicleType determineSpotType(int spotNumber) {
        return (spotNumber % 3 == 0) ? VehicleType.HANDICAPPED :
                (spotNumber % 2 == 0) ? VehicleType.REGULAR :
                        VehicleType.COMPACT;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && spot.getType() == vehicle.getType()) {
                spot.occupy();
                return spot;
            }
        }
        return null;
    }

    public void vacateSpot(ParkingSpot spot) {
        spot.vacate();
    }

    public List<ParkingSpot> getAvailableSpots() {
        List<ParkingSpot> availableSpots = new ArrayList<>();
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                availableSpots.add(spot);
            }
        }
        return availableSpots;
    }
}

public class ParkingLotExample {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10);


        Vehicle car1 = new Vehicle("ABC123", VehicleType.REGULAR);
        Vehicle car2 = new Vehicle("XYZ789", VehicleType.COMPACT);
        Vehicle car3 = new Vehicle("DEF456", VehicleType.HANDICAPPED);


        ParkingSpot spot1 = parkingLot.parkVehicle(car1);
        ParkingSpot spot2 = parkingLot.parkVehicle(car2);
        ParkingSpot spot3 = parkingLot.parkVehicle(car3);


        System.out.println("Parked Vehicles:");
        System.out.println("Spot 1: " + spot1.getSpotNumber() + " - " + car1.getLicensePlate());
        System.out.println("Spot 2: " + spot2.getSpotNumber() + " - " + car2.getLicensePlate());
        System.out.println("Spot 3: " + spot3.getSpotNumber() + " - " + car3.getLicensePlate());

        parkingLot.vacateSpot(spot1);

        System.out.println("\nAvailable Spots:");
        List<ParkingSpot> availableSpots = parkingLot.getAvailableSpots();
        for (ParkingSpot spot : availableSpots) {
            System.out.println("Spot " + spot.getSpotNumber() + " - " + spot.getType());
        }

        ParkingSpot spot5 = new ParkingSpot(1, VehicleType.REGULAR);
        ParkingSpot spot6 = new ParkingSpot(1, VehicleType.REGULAR);
    }
}