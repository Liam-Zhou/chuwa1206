import java.util.Date;

public class Spot {
    private int spotNumber;
    private boolean isEmpty;
    private Vehicle parkVehicle;

    public Spot(int slotNumber) {
        this.spotNumber = slotNumber;
        isEmpty = true;
    }

    public int getSlotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public Vehicle getParkVehicle() {
        return parkVehicle;
    }

    public void setParkVehicle(Vehicle parkVehicle) {
        this.parkVehicle = parkVehicle;
    }

    public void vacateSlot() {
        parkVehicle = null;
        this.isEmpty = true;
    }

    public void occupySlot(Vehicle parkVehicle) {
        this.parkVehicle = parkVehicle;
        this.isEmpty = false;
    }

}
