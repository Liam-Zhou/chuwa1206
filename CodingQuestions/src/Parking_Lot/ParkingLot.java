package Parking_Lot;

public class ParkingLot {
    private int capacity;
    private boolean isFull;
    private Level[] levels;

    public ParkingLot(int capacity, int levels) {
        this.capacity = capacity;
        this.levels = new Level[levels];
    }

    public int getCapacity() {
        return capacity;
    }

    public Level[] getLevels() {
        return levels;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.assignSpot(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.removeVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (Level level : levels) {
            if (!level.isFull()) {
                return false;
            }
        }
        return true;
    }

    public void displayAvailableSpots() {
        for (Level level : levels) {
            if (!level.isFull()) {
                System.out.println("Floor: " + level.getFloor());
                level.displayAvailableSpots();
            }
        }
    }
}
