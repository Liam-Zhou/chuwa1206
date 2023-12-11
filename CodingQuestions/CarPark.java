public class CarPark {

    private CarParkSlot[] carParkSlots;
    private int totalCapacity;
    private int openSlots;

    public CarPark(int totalCapacity) {
        this.totalCapacity = totalCapacity;
        this.carParkSlots = new CarParkSlot[totalCapacity];
        this.openSlots = totalCapacity;
        for (int index = 0; index < totalCapacity; index++) {
            carParkSlots[index] = new CarParkSlot(index);
        }
    }

    public boolean addVehicle(Automobile automobile) {
        if (openSlots == 0) return false;

        for (CarParkSlot slot : carParkSlots) {
            if (slot.isFree()) {
                slot.placeVehicle(automobile);
                openSlots--;
                return true;
            }
        }
        return false;
    }

    public boolean removeVehicle(Automobile automobile) {
        for (CarParkSlot slot : carParkSlots) {
            if (slot.getCurrentVehicle() == automobile) {
                slot.clearVehicle();
                openSlots++;
                return true;
            }
        }
        return false;
    }

    public int countOpenSlots() {
        return openSlots;
    }

    private class CarParkSlot {
        private int slotId;
        private Automobile automobile;

        public CarParkSlot(int slotId) {
            this.slotId = slotId;
        }

        public boolean isFree() {
            return automobile == null;
        }

        public void placeVehicle(Automobile automobile) {
            this.automobile = automobile;
        }

        public void clearVehicle() {
            this.automobile = null;
        }

        public Automobile getCurrentVehicle() {
            return automobile;
        }
    }

    public class Automobile {
        private String registrationNumber;

        public Automobile(String registrationNumber) {
            this.registrationNumber = registrationNumber;
        }

    }
}

