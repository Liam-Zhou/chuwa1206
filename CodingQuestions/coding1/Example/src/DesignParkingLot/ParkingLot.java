package DesignParkingLot;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    List<ParkingSpace> spaces = new ArrayList<>();
    int size;
    int level;

    public ParkingLot(int size, int level) {
        this.size = size;
        this.level = level;

        for (int j = 0; j < size / level; j++) {
            spaces.add(new ParkingSpace(1, j, CarType.CAR));
        }
        for (int j = 0; j < size / level; j++) {
            spaces.add(new ParkingSpace(2, j, CarType.TRUCK));
        }
        for (int j = 0; j < size / level; j++) {
            spaces.add(new ParkingSpace(3, j, CarType.MOTORCYCLE));
        }
    }

    public boolean parkCar(Car car) {
        for (int i = 0; i < spaces.size(); i++) {
            if (!spaces.get(i).isOccupied()) {
                spaces.get(i).setCar(car);
                spaces.get(i).setOccupied(true);
                return true;
            }
        }
        System.out.println("The parking lot is full.");
        return false;
    }

    public boolean clearSpace(int level, int num) {
        ParkingSpace cur = spaces.get((level - 1) * size / level + num);
        cur.setOccupied(false);
        cur.setCar(null);
        return true;
    }

}
