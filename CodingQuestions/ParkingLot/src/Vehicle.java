public class Vehicle {
    private int vehicleNum;
    private VehicleType vehicleType;
    private ParkingSpot parkingSpot;

    //constructor
    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    //getter and setter
    public int getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(int vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
