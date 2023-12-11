package com.chuwa.learn;

public class ParkingLot {
    private Level[] levels;
    private final int NUM_LEVELS = 5;

    public ParkingLot(){
        levels = new Level[NUM_LEVELS];
        for (int i = 0; i < NUM_LEVELS; i++){
            levels[i] = new Level(i, 30);
        }
    }

    public boolean parkVehicle(Vehicle vehicle){
        for (Level level : levels) {
            if (level.parkVehicle(vehicle))
                return true;
        }
        return false;
    }
}
