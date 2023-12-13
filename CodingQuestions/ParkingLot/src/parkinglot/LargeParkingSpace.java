package parkinglot;

import vehicle.VehicleSize;

public class LargeParkingSpace extends ParkingSpace{

    public LargeParkingSpace() {
        super(VehicleSize.LARGE);
    }

    @Override
    public boolean canPark(VehicleSize size) {
        return true;
    }
}
