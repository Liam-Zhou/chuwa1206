package org.example;
import java.util.ArrayList;
import java.util.List;


public class ParkingLot {
    private List<ParkingSpot> carSpots;
    private List<ParkingSpot> motorSpots;
    int carSpotsAvailable;
    int motorSpotsAvailable;
    private String name;

    public ParkingLot(String name, int carSpotsNum, int motorSpotsNum) {
        this.name = name;
        carSpotsAvailable = carSpotsNum;
        motorSpotsAvailable = motorSpotsNum;
        carSpots = new ArrayList<ParkingSpot>(carSpotsNum);
        motorSpots = new ArrayList<ParkingSpot>(motorSpotsNum);
        for (int i = 0; i < carSpotsNum; i++) {
            carSpots.add(new ParkingSpot("A"+i, VehicleType.CAR));
        }
        for (int i = 0; i < motorSpotsNum; i++) {
            motorSpots.add(new ParkingSpot("B"+i, VehicleType.MOTORCYCLE));
        }

    }

    public boolean isFull(VehicleType type) {
        if (type.equals(VehicleType.CAR)) return carSpotsAvailable == 0;
        return motorSpotsAvailable == 0;
    }

    private ArrayList<ParkingSpot> getAvailableSpots(List<ParkingSpot> spots) {
        ArrayList<ParkingSpot> available = new ArrayList<>();
        for (ParkingSpot spot: spots) {
            if (!spot.isOccupied()) {
                available.add(spot);
            }
        }
        return available;
    }

    public ArrayList<ParkingSpot> availableSpots(VehicleType type) {
        if (type.equals(VehicleType.CAR)) {
            return getAvailableSpots(carSpots);
        }
        else return getAvailableSpots(motorSpots);
    }

    public int parkVehicle(Vehicle vehicle, ParkingSpot spot) {
        if (spot.getVehicleType() != vehicle.getType()) {
            System.out.println("Vehicle type is not matched, the vehicle cannot park here");
            return 0; // not successful
        }
        spot.occupy(vehicle);
        if (vehicle.getType().equals(VehicleType.CAR)) carSpotsAvailable--;
        else motorSpotsAvailable--;
        return 1; //successful
    }

    public void vacateSpot(ParkingSpot spot) {
        spot.vacate();
        if (spot.getVehicleType().equals(VehicleType.CAR)) carSpotsAvailable++;
        else motorSpotsAvailable++;
    }

}
