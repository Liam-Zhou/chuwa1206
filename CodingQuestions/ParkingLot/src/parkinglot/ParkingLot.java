package parkinglot;

import vehicle.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLot {
    private final Map<Integer, ParkingLotLevel> levels;
    private final Map<String, ParkingSpace> occupiedSpaces;

    public ParkingLot(List<ParkingLotLevel> levels) {
        this.levels = new HashMap<>();
        for (int i = 0; i < levels.size(); i++) {
            this.levels.put(i + 1, levels.get(i));
        }
        this.occupiedSpaces = new HashMap<>();
    }

    public int getNumLevels() {
        return levels.size();
    }

    public ParkingSpace park(int level, Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalStateException("Attempting to park with null Vehicle");
        }
        if (occupiedSpaces.containsKey(vehicle.getLicensePlate())) {
            throw new IllegalArgumentException("Vehicle with license " + vehicle.getLicensePlate() + " is already parked");
        }
        ParkingSpace space = this.levels.get(level).getSpaceForVehicleSize(vehicle);
        if (space == null) {
            throw new IllegalArgumentException("No space available for " + vehicle + " at this level");
        }
        space.park(vehicle);
        this.occupiedSpaces.put(vehicle.getLicensePlate(), space);
        return space;
    }

    public boolean vacate(String licensePlate) {
        if (!occupiedSpaces.containsKey(licensePlate)) {
            return false;
        }
        ParkingSpace space = occupiedSpaces.get(licensePlate);
        space.vacate();
        return true;
    }

    public String toString() {
        return levels.entrySet().stream().map((entry) ->
            String.format(
                """
                Level: %d
                %s       \s
                """,
                entry.getKey(),
                entry.getValue().toString()
            )
        ).collect(Collectors.joining());
    }
}
