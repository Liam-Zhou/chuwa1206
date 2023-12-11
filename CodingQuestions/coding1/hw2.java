
enum VehicleType {
    SMALL, MEDIUM, LARGE
}


class Vehicle {
    private String licensePlate;
    private VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }
}


class ParkingSpot {
    private Vehicle vehicle;
    private VehicleType type;
    private int number;

    public ParkingSpot(int number, VehicleType type) {
        this.number = number;
        this.type = type;
    }

    public boolean fit(Vehicle vehicle) {                                             
        return this.vehicle == null && vehicle.getType().ordinal() <= type.ordinal(); 
    }                                                                                 

    public void park(Vehicle vehicle) throws Exception {
        if (!fit(vehicle)) {
            throw new Exception("The vehicle doesn't fit in this spot");
        }
        this.vehicle = vehicle;
    }

    public void leave() {
        this.vehicle = null;
    }

    public boolean isAvailable() {
        return this.vehicle == null;
    }

}


class ParkingLot {
    private ParkingSpot[] spots;

    public ParkingLot(int numberOfSpots) {
        spots = new ParkingSpot[numberOfSpots];
        for (int i = 0; i < numberOfSpots; i++) {
            VehicleType type = VehicleType.values()[i % VehicleType.values().length];
            spots[i] = new ParkingSpot(i, type);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.fit(vehicle)) {
                try {
                    spot.park(vehicle);
                    return true;
                } catch (Exception e) {
                    throw new MyCustomException(e);
                }
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(10);
        Vehicle car = new Vehicle("ABC123", VehicleType.MEDIUM);

        if (lot.parkVehicle(car)) {
            System.out.println("Vehicle parked!");
        } else {
            System.out.println("Failed to park the vehicle.");
        }
    }
}