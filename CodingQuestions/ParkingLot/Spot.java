package ParkingLot;

public class Spot {
        private int spotNumber;
        private boolean isOccupied;
        private Vehicle parkingVehicle;

        public Spot(int spotNumber) {
            this.spotNumber = spotNumber;
            this.isOccupied = false;
            this.parkingVehicle = null;
        }

        public int getSpotNumber() {
            return spotNumber;
        }

        public boolean isOccupied() {
            return isOccupied;
        }

        public Vehicle getParkedVehicle() {
            return parkingVehicle;
        }

        public void parkVehicle(Vehicle vehicle) {
            this.parkingVehicle = vehicle;
            this.isOccupied = true;
        }

        public void closeSpot() {
            this.parkingVehicle = null;
            this.isOccupied = false;
        }
    }

