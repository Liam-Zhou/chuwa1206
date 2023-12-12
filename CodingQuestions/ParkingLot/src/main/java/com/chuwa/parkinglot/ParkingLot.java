package com.chuwa.parkinglot;
import com.chuwa.vehicles.Vehicles;

import java.util.LinkedList;
import java.util.Queue;

public class ParkingLot {
    private static class Slot{
        private final int ID;
        private Vehicles veh;

        public int getID() {
            return ID;
        }

//        public void setID(int ID) {
//            this.ID = ID;
//        }

        public Vehicles getVeh() {
            return veh;
        }

        public void setVeh(Vehicles veh) {
            this.veh = veh;
        }

        public Slot(int ID){
            this.ID = ID;
            setVeh(null);
        }
    }

    private final int MAX_CAPACITY = 10;
    private final Queue<Slot> vacant; //LRU
    private final Slot[] slots = new Slot[MAX_CAPACITY]; // why these two can be final

    public ParkingLot(){
        vacant = new LinkedList<>();
        for(int i = 0; i < MAX_CAPACITY; i++){
            Slot s = new Slot(i);
            vacant.add(s);
            slots[i] = s;
        }
    }

    public void park(Vehicles veh){
        if(vacant.isEmpty()){
            System.out.println("No vacant slot!");
            return;
        }
        Slot slot = vacant.poll();
        slot.setVeh(veh);
        System.out.printf("%s %s parks at slot %d%n", veh.getType(), veh.getPlate(), slot.getID());
    }

    public void leave(int slotID){
        if(slotID < 0 || slotID >= MAX_CAPACITY) return;
        if(slots[slotID].getVeh() != null){ // a car park here
            Slot s = slots[slotID];
            Vehicles veh = s.getVeh();
            s.setVeh(null);
            vacant.offer(s);
            System.out.printf("%s %s at slot %d leave%n", veh.getType(), veh.getPlate(), slotID);
        }
        else{
            System.out.println("No car leave.");
        }
    }
}

