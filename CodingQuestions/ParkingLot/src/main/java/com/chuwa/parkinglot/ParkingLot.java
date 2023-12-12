package com.chuwa.parkinglot;
import com.chuwa.vehicles.Car;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParkingLot {
    private static class Slot{
        private final int ID;
        private Car car;

        public int getID() {
            return ID;
        }

//        public void setID(int ID) {
//            this.ID = ID;
//        }

        public Car getCar() {
            return car;
        }

        public void setCar(Car car) {
            this.car = car;
        }

        public Slot(int ID){
            this.ID = ID;
            setCar(null);
        }
    }

    private final int MAX_CAPACITY = 10;
    private Queue<Slot> vacant;
    private Slot[] slots = new Slot[MAX_CAPACITY];

    public ParkingLot(){
        vacant = new LinkedList<>();
        for(int i = 0; i < MAX_CAPACITY; i++){
            Slot s = new Slot(i);
            vacant.add(s);
            slots[i] = s;
        }
    }

    public void park(Car car){
        if(vacant.isEmpty()){
            System.out.println("No vacant slot!");
            return;
        }
        Slot slot = vacant.poll();
        slot.setCar(car);
        System.out.printf("Car %s parks at slot %d%n", car.getPlate(), slot.getID());
    }

    public void leave(int slotID){
        if(slotID < 0 || slotID >= MAX_CAPACITY) return;
        if(slots[slotID].getCar() != null){ // a car park here
            Slot s = slots[slotID];
            String carplate = s.getCar().getPlate();
            s.setCar(null);
            vacant.offer(s);
            System.out.printf("Car %s at slot %d leave%n", carplate, slotID);
        }
        else{
            System.out.println("No car leave.");
        }
    }
}

