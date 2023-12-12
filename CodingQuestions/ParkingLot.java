// Enum for vehicle sizes
enum VehicleSize {
    MOTORCYCLE,
    COMPACT,
    LARGE
}

// Abstract Vehicle class
abstract class Vehicle {
    protected int requiredSpots;
    protected VehicleSize size;
    protected String licensePlate; // License plate identifier

    protected List<ParkingSpot> parkedSpots = new ArrayList<>(); // Parking spots occupied

    public int getRequiredSpots() {
        return requiredSpots;
    }

    public VehicleSize getSize() {
        return size;
    }

    // Park vehicle in the given spot
    public void parkInSpot(ParkingSpot spot) {
        parkedSpots.add(spot);
    }

    // Remove vehicle from its spots
    public void clearSpots() {
        for (ParkingSpot spot : parkedSpots) {
            spot.removeVehicle();
        }
        parkedSpots.clear();
    }

    // To be implemented in subclasses
    public abstract boolean canFitInSpot(ParkingSpot spot);
    public abstract void display();
}

// Concrete Vehicle subclasses
class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        this.licensePlate = licensePlate;
        this.requiredSpots = 1;
        this.size = VehicleSize.MOTORCYCLE;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }

    @Override
    public void display() {
        System.out.print("Motorcycle");
    }
}

class Car extends Vehicle {
    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
        this.requiredSpots = 1;
        this.size = VehicleSize.COMPACT;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.LARGE || spot.getSize() == VehicleSize.COMPACT;
    }

    @Override
    public void display() {
        System.out.print("Car");
    }
}

class Bus extends Vehicle {
    public Bus(String licensePlate) {
        this.licensePlate = licensePlate;
        this.requiredSpots = 5;
        this.size = VehicleSize.LARGE;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.LARGE;
    }

    @Override
    public void display() {
        System.out.print("Bus");
    }
}

// ParkingSpot class
class ParkingSpot {
    private Vehicle parkedVehicle;
    private VehicleSize spotSize;
    private int row;
    private int spotNumber;
    private ParkingLevel level;

    public ParkingSpot(ParkingLevel level, int row, int spotNumber, VehicleSize size) {
        this.level = level;
        this.row = row;
        this.spotNumber = spotNumber;
        this.spotSize = size;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return isAvailable() && vehicle.canFitInSpot(this);
    }

    public boolean park(Vehicle vehicle) {
        if (!canFitVehicle(vehicle)) {
            return false;
        }
        this.parkedVehicle = vehicle;
        vehicle.parkInSpot(this);
        return true;
    }

    public void removeVehicle() {
        if (parkedVehicle != null) {
            level.notifySpotFreed();
            parkedVehicle = null;
        }
    }

    public VehicleSize getSize() {
        return spotSize;
    }

    public void display() {
        if (parkedVehicle == null) {
            System.out.print(spotSize.toString().charAt(0));
        } else {
            parkedVehicle.display();
        }
    }
}

// ParkingLevel class
class ParkingLevel {
    private int floorLevel;
    private ParkingSpot[] spots;
    private int availableSpots;
    private int spotsPerRow;

    public ParkingLevel(int floorLevel, int numRows, int spotsPerRow) {
        this.floorLevel = floorLevel;
        this.spotsPerRow = spotsPerRow;
        int totalSpots = numRows * spotsPerRow;
        this.spots = new ParkingSpot[totalSpots];

        for (int row = 0, spotIndex = 0; row < numRows; ++row) {
            for (int spot = 0; spot < spotsPerRow; ++spot, ++spotIndex) {
                VehicleSize size = determineSpotSize(spot, spotsPerRow);
                spots[spotIndex] = new ParkingSpot(this, row, spotIndex, size);
            }
        }
        this.availableSpots = totalSpots;
    }

    private VehicleSize determineSpotSize(int spot, int spotsPerRow) {
        int threshold = spotsPerRow / 4;
        if (spot < threshold) {
            return VehicleSize.MOTORCYCLE;
        } else if (spot < threshold * 3) {
            return VehicleSize.COMPACT;
        } else {
            return VehicleSize.LARGE;
        }
    }

    // Other ParkingLevel methods
    // ...

    public void notifySpotFreed() {
        availableSpots++;
    }

    public void display() {
        for (ParkingSpot spot : spots) {
            spot.display();
        }
        System.out.println();
    }
}

// ParkingLot class
public class ParkingLot {
    private ParkingLevel[] levels;

    public ParkingLot(int numLevels, int numRows, int spotsPerRow) {
        levels = new ParkingLevel[numLevels];
        for (int i = 0; i < numLevels; i++) {
            levels[i] = new ParkingLevel(i, numRows, spotsPerRow);
        }
    }

    // Other ParkingLot methods
    // ...

    public void display() {
        for (ParkingLevel level : levels) {
            level.display();
        }
    }
}
