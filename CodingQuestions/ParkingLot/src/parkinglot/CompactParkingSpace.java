package parkinglot;

import vehicle.VehicleSize;

public class CompactParkingSpace extends ParkingSpace {

    public CompactParkingSpace() {
        super(VehicleSize.COMPACT);
    }

    @Override
    public boolean canPark(VehicleSize size) {
        return size.equals(VehicleSize.COMPACT);
    }
}
