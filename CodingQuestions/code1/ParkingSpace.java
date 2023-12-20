class ParkingSpace {
    private int spaceNumber;
    private boolean occupied;
    private Vehicle parkedVehicle;

    public ParkingSpace(int spaceNumber) {
        this.spaceNumber = spaceNumber;
        this.occupied = false;
        this.parkedVehicle = null;
    }

    public int getSpaceNumber() {
        return spaceNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.occupied = true;
        System.out.println(vehicle.getType() + " with license plate " + vehicle.getLicensePlate() +
                " parked in space " + spaceNumber);
    }

    public void vacateSpace() {
        System.out.println("Space " + spaceNumber + " vacated");
        this.parkedVehicle = null;
        this.occupied = false;
    }
}
