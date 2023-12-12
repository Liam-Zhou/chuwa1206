import java.util.*;

public class Main {
    enum VehicleType {
        CAR, TRUCK, ELECTRIC, HANDICAPPED
    }

    enum ParkingSpotType {
        COMPACT, LARGE, HANDICAPPED
    }

    static class Vehicle {
        private VehicleType type;

        public Vehicle(VehicleType type) {
            this.type = type;
        }

        public VehicleType getType() {
            return type;
        }
    }

    static class ParkingSpot {
        private ParkingSpotType type;
        private Vehicle vehicle;
        private boolean available;

        public ParkingSpot(ParkingSpotType type) {
            this.type = type;
            this.available = true;
        }

        public boolean park(Vehicle vehicle) {
            if (available) {
                this.vehicle = vehicle;
                available = false;
                return true;
            }
            return false;
        }

        public boolean unpark() {
            if (!available) {
                this.vehicle = null;
                available = true;
                return true;
            }
            return false;
        }

        public ParkingSpotType getType() {
            return type;
        }

        public boolean isAvailable() {
            return available;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }
    }

    static class ParkingLot {
        private final Map<VehicleType, List<ParkingSpot>> spots;

        public ParkingLot(int numCompact, int numLarge, int numHandicapped, int numElectric) {
            spots = new HashMap<>();
            spots.put(VehicleType.CAR, new ArrayList<>());
            spots.put(VehicleType.TRUCK, new ArrayList<>());
            spots.put(VehicleType.HANDICAPPED, new ArrayList<>());
            spots.put(VehicleType.ELECTRIC, new ArrayList<>());

            for (int i = 0; i < numCompact; i++) {
                spots.get(VehicleType.CAR).add(new ParkingSpot(ParkingSpotType.COMPACT));
            }
            for (int i = 0; i < numLarge; i++) {
                spots.get(VehicleType.TRUCK).add(new ParkingSpot(ParkingSpotType.LARGE));
            }
            for (int i = 0; i < numHandicapped; i++) {
                spots.get(VehicleType.HANDICAPPED).add(new ParkingSpot(ParkingSpotType.HANDICAPPED));
            }
            for (int i = 0; i < numElectric; i++) {
                spots.get(VehicleType.ELECTRIC).add(new ParkingSpot(ParkingSpotType.COMPACT));
            }
        }

        public boolean parkVehicle(Vehicle vehicle) {
            List<ParkingSpot> availableSpots = spots.get(vehicle.getType());
            if (availableSpots == null) {
                return false;
            }
            for (ParkingSpot spot : availableSpots) {
                if (spot.isAvailable() && spot.park(vehicle)) {
                    return true;
                }
            }
            return false;
        }

        public boolean unparkVehicle(Vehicle vehicle) {
            List<ParkingSpot> vehicleSpots = spots.get(vehicle.getType());
            if (vehicleSpots == null) {
                return false;
            }
            for (ParkingSpot spot : vehicleSpots) {
                if (!spot.isAvailable() && spot.getVehicle().equals(vehicle)) {
                    spot.unpark();
                    return true;
                }
            }
            return false;
        }
    }

    public static class ParkingLotTest {
        public static void main(String[] args) {
            ParkingLot parkingLot = new ParkingLot(10, 5, 3, 2);

            Vehicle car = new Vehicle(VehicleType.CAR);
            Vehicle truck = new Vehicle(VehicleType.TRUCK);
            Vehicle electric = new Vehicle(VehicleType.ELECTRIC);

            System.out.println("Car parking: " + parkingLot.parkVehicle(car));
            System.out.println("Truck parking: " + parkingLot.parkVehicle(truck));
            System.out.println("Electric car parking: " + parkingLot.parkVehicle(electric));

            System.out.println("Car leaving: " + parkingLot.unparkVehicle(car));
            System.out.println("Truck leaving: " + parkingLot.unparkVehicle(truck));
            System.out.println("Electric car leaving: " + parkingLot.unparkVehicle(electric));
        }
    }
}
