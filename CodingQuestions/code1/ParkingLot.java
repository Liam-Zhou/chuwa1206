import java.util.ArrayList;
import java.util.List;

// Class representing a ParkingLot
class ParkingLot {
    private List<ParkingSpace> spaces;

    public ParkingLot(int capacity) {
        spaces = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            spaces.add(new ParkingSpace(i));
        }
    }

    public ParkingSpace findAvailableSpace() {
        for (ParkingSpace space : spaces) {
            if (!space.isOccupied()) {
                return space;
            }
        }
        return null; // No available space
    }

    public void parkVehicle(Vehicle vehicle) {
        ParkingSpace availableSpace = findAvailableSpace();
        if (availableSpace != null) {
            availableSpace.parkVehicle(vehicle);
        } else {
            System.out.println("No available space for parking " + vehicle.getType() +
                    " with license plate " + vehicle.getLicensePlate());
        }
    }

    public void vacateSpace(int spaceNumber) {
        for (ParkingSpace space : spaces) {
            if (space.getSpaceNumber() == spaceNumber) {
                space.vacateSpace();
                return;
            }
        }
        System.out.println("Invalid space number " + spaceNumber);
    }

    public static void main(String[] args) {
        // Create a parking lot with 10 spaces
        ParkingLot parkingLot = new ParkingLot(10);

        // Create vehicles
        Vehicle car1 = new Vehicle("ABC123", VehicleType.CAR);
        Vehicle motorcycle1 = new Vehicle("XYZ456", VehicleType.MOTORCYCLE);

        // Park vehicles in the parking lot
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(motorcycle1);

        // Vacate a parking space
        parkingLot.vacateSpace(1);
    }
}