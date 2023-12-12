public class Slot {
    private int slotId;
    private boolean empty;
    private Vehicle vehicle;

    public Slot(int slotId, boolean empty) {
        this.slotId = slotId;
        this.empty = empty;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public void park(Vehicle vehicle) {
        if(isEmpty()) {
            this.vehicle = vehicle;
            this.empty = false;
        } else {
            System.out.println("slot " + this.slotId + " is not available.");
        }
    }

    public void unpark() {
        if(isEmpty()) {
            return;
        } else {
            this.vehicle = null;
            this.empty = true;
        }
    }
}
