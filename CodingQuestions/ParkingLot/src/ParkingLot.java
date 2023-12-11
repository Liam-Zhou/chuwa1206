import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<CompactSpot> compactSpotsList = new ArrayList<>();
    List<LargeSpot> largeSpotsList = new ArrayList<>();
    List<BikeSpot> bikeSpotsList = new ArrayList<>();
    int freeCompactSpot;
    int freeLargeSpot;
    int freeBikeSpot;

    public ParkingLot(int freeBikeSpot, int freeCompactSpot, int freeLargeSpot) {
        this.freeBikeSpot = freeBikeSpot;
        this.freeCompactSpot = freeCompactSpot;
        this.freeLargeSpot = freeLargeSpot;
    }

    //method
    //park
    public void parkVehicle(Vehicle vehicle) {
        System.out.println("Parking in progress" + vehicle.getVehicleType());

        if (vehicle.getVehicleType().equals(VehicleType.TRUCK)) {
            if (freeLargeSpot > 0) {
                parkLargeCar(vehicle);
            } else {
                System.out.println("FULL, 886");
            }
        } else if (vehicle.getVehicleType().equals(VehicleType.CAR)) {
            if (freeCompactSpot > 0) {
                parkCompactCar(vehicle);
            } else if (freeLargeSpot > 0) {
                parkLargeCar(vehicle);
            } else {
                System.out.println("FULL, 88");
            }

        } else if (vehicle.getVehicleType().equals(VehicleType.BIKE)) {
            if (freeBikeSpot > 0) {
                parkBikeCar(vehicle);
            } else if (freeCompactSpot > 0) {
                parkCompactCar(vehicle);
            } else if (freeLargeSpot > 0) {
                parkLargeCar(vehicle);
            } else {
                System.out.println("FULL, 别来了");
            }
        }
    }

    public void parkLargeCar(Vehicle vehicle) {
        LargeSpot largeSpot = new LargeSpot(ParkingSpotType.LARGE);
        largeSpot.setFree(false);
        largeSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(largeSpot);

        largeSpotsList.add(largeSpot);
        freeLargeSpot--;
        System.out.println("OK" + vehicle.getVehicleType() + "parked");
    }
    public void parkCompactCar(Vehicle vehicle) {
        CompactSpot compactSpot = new CompactSpot(ParkingSpotType.COMPACT);
        compactSpot.setFree(false);
        compactSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(compactSpot);

        compactSpotsList.add(compactSpot);
        freeCompactSpot--;
        System.out.println("OK" + vehicle.getVehicleType() + "OK");
    }
    public void parkBikeCar(Vehicle vehicle) {
        BikeSpot bikeSpot = new BikeSpot(ParkingSpotType.BIKE);
        bikeSpot.setFree(false);
        bikeSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(bikeSpot);

        bikeSpotsList.add(bikeSpot);
        freeBikeSpot--;
        System.out.println("OK" + vehicle.getVehicleType() + "O");
    }

    //unpark
    public void unParkVehicle(Vehicle vehicle) {
        System.out.println("886" + vehicle.getVehicleType());

        //locate the current parkinglot info
        ParkingSpot parkingSpot = vehicle.getParkingSpot();
        parkingSpot.setFree(true);

        if (vehicle.getVehicleType().equals(VehicleType.TRUCK)) {
            if (largeSpotsList.remove(parkingSpot)) {
                System.out.println("欢迎下次光临");
                freeLargeSpot++;
            } else {
                System.out.println("没你的车");
            }
        }
        if (vehicle.getVehicleType().equals(VehicleType.CAR)) {
            if (compactSpotsList.remove(parkingSpot)) {
                System.out.println("欢迎下次光临");
                freeCompactSpot++;
            } else {
                System.out.println("没你的车");
            }
        }
        if (vehicle.getVehicleType().equals(VehicleType.BIKE)) {
            if (bikeSpotsList.remove(parkingSpot)) {
                System.out.println("欢迎下次光临");
                freeBikeSpot++;
            } else {
                System.out.println("没你的车");
            }
        }
    }
}
