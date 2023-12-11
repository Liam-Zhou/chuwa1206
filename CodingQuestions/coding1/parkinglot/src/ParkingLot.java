import java.util.LinkedList;
import java.util.List;

public class ParkingLot {
    private int capacity;
    private List<Slot> slotList;
    private int remainSlots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.remainSlots = capacity;
        this.slotList = new LinkedList<>();
        for(int i = 0; i < capacity; i ++) {
            slotList.add(new Slot(i + 1, true));
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRemainSlots() {
        return remainSlots;
    }

    public void park(int slotId, Vehicle vehicle) {
        if(slotId > capacity || slotId < 1) {
            System.out.println("no such slot.");
            return;
        }
        Slot slot = slotList.get(slotId - 1);
        if(slot.isEmpty()) {
            slot.park(vehicle);
            remainSlots --;
        } else {
            System.out.println("slot " + slot.getSlotId() + " is not available.");
        }
    }

    public void unpark(int slotId) {
        if(slotId > capacity || slotId < 1) {
            System.out.println("no such slot.");
            return;
        }
        Slot slot = slotList.get(slotId - 1);
        if(slot.isEmpty()) {
            return;
        } else {
            slot.unpark();
            remainSlots ++;
        }
    }

}
