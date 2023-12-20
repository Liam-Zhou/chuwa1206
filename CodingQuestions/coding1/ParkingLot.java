public class ParkingLot {
    private Level[] lvls;
    private final int NUM_LVLS = 2;
    private int numberSpots;

    public ParkingLot(int numberSpots) {
        this.numberSpots = numberSpots;
        lvls = new Level[NUM_LVLS];
        for (int j = 0; j < NUM_LVLS; j++) {
            lvls[j] = new Level(j, numberSpots);
            System.out.println("Level " + j + " created with" + numberSpots + "spots");
        }
    }

    public boolean parkVehicle(Vehicle vh) {
        for (int i = 0; i < lvls.length; i++) {
            if (lvls[i].parkVehicle(vh)) {
                System.out.println("Level " + i + " with Vehicle Number " + vh.licensePlate + " Parked");
                return true;
            }
        }
        System.out.println("Parking lot is full");
        return false;
    }

    public boolean leave(Vehicle vh, int lvl) {
        lvls[lvl].spotFreed();
        System.out.println("Spot freed from Level " + lvl + " and Car " + vh.licensePlate + " exited");
        return true;
    }
}
