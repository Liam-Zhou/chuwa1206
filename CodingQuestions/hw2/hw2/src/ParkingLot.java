public class ParkingLot {

    private ParkingSpot[] spots;
    private int capacity;
    private int availableSpots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.spots = new ParkingSpot[capacity];
        this.availableSpots = capacity;
        for (int i = 0; i < capacity; i++) {
            spots[i] = new ParkingSpot(i);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (availableSpots == 0) return false;

        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                spot.assignVehicle(vehicle);
                availableSpots--;
                return true;
            }
        }
        return false;
    }

    public boolean leaveVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.getVehicle() == vehicle) {
                spot.removeVehicle();
                availableSpots++;
                return true;
            }
        }
        return false;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

    private class ParkingSpot {
        private int spotNumber;
        private Vehicle vehicle;

        public ParkingSpot(int spotNumber) {
            this.spotNumber = spotNumber;
        }

        public boolean isAvailable() {
            return vehicle == null;
        }

        public void assignVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
        }

        public void removeVehicle() {
            this.vehicle = null;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }
    }

    public class Vehicle {
        private String licensePlate;

        public Vehicle(String licensePlate) {
            this.licensePlate = licensePlate;
        }

    }
}
