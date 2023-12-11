package parkinglot;

import vehicle.Vehicle;
import vehicle.VehicleSize;

import java.util.List;

public class ParkingLotLevel {

    private final List<ParkingSpace> parkingSpaces;

    public ParkingLotLevel(List<ParkingSpace> parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    public ParkingSpace getSpaceForVehicleSize(Vehicle vehicle) {
        List<ParkingSpace> availableSpaces = getAvailableSpacesForVehicleSize(vehicle.getSize());
        if (availableSpaces.isEmpty()) {
            return null;
        }
        return availableSpaces.get(0);
    }

    private List<ParkingSpace> getAvailableSpacesForVehicleSize(VehicleSize size) {
        return parkingSpaces
                .stream()
                .filter((parkingSpace -> parkingSpace.isVacant() && parkingSpace.canPark(size)))
                .toList();
    }

    private int numDesignatedSpacesForVehicleSize(VehicleSize size) {
        return (int) parkingSpaces // could be lossy but works for now
                .stream()
                .filter((parkingSpace -> parkingSpace.isVacant() && parkingSpace.getSize().equals(size)))
                .count();
    }

    public String toString() {
        return String.format(
            "Total spaces: %d, remaining %s: %d, remaining %s: %d",
            parkingSpaces.size(),
            VehicleSize.COMPACT,
            numDesignatedSpacesForVehicleSize(VehicleSize.COMPACT),
            VehicleSize.LARGE,
            numDesignatedSpacesForVehicleSize(VehicleSize.LARGE)
        );
    }
}
