public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0;
    private static final int SLOT_PER_ROW = 10;

    public Level(int floor, int numSpots) {
        this.floor = floor;
        availableSpots = numSpots;
        spots = new ParkingSpot[numSpots];

        int largeSpots = numSpots / 4;
        int bikeSpots = numSpots / 4;
        int compactSpots = numSpots - largeSpots - bikeSpots;

        for (int j = 0; j < numSpots; j++)
        {
            VehicleSize siz = VehicleSize.Motorcycle;
            if (j < largeSpots + compactSpots)
            {
                siz = VehicleSize.Car;
            }
            int row = j / SLOT_PER_ROW;
            spots[j] = new ParkingSpot(this, row, j, siz);
        }
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

    private boolean parkStartingAtSpot(int num, Vehicle vh) {
        boolean success = true;
        for (int j = num; j < num + vh.getSpotsNeeded(); j++) {
            success &= spots[j].park(vh);
        }
        availableSpots = availableSpots - vh.spotsNeeded;
        return success;
    }

    private int findAvailableSpots(Vehicle vh) {
        int spotsNeeded = vh.getSpotsNeeded();
        int lastRow = -1;
        int spotsFound = 0;

        for (int j = 0; j < spots.length; j++) {
            if (lastRow != spots[j].getRow()) {
                spotsFound = 0;
                lastRow = spots[j].getRow();
            }
            if (spots[j].canFitVehicle(vh)) {
                spotsFound += 1;
            } else {
                spotsFound = 0;
            }
            if (spotsFound == spotsNeeded) {
                if(vh.getSize() == VehicleSize.Car)
                    System.out.print("It is a Car parked in ");
                else
                    System.out.print("It is a Motorcycle parked in ");
                System.out.println("Row Number " + lastRow);
                return j - (spotsNeeded - 1);
            }
        }
        return -1;
    }

    public boolean parkVehicle(Vehicle vh) {
        if (getAvailableSpots() < vh.getSpotsNeeded()) {
            return false;
        }
        int spotNumber = findAvailableSpots(vh);
        if (spotNumber < 0) {
            return false;
        }
        System.out.println("Spot Number " + spotNumber);
        return parkStartingAtSpot(spotNumber, vh);
    }

    public void spotFreed() {
        availableSpots += 1;
        System.out.println("Available Spots in the current level: " + availableSpots);
    }
}

