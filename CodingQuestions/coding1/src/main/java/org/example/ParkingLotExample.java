package org.example;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ParkingLotExample {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("Parking Lot A",1, 1);
        ArrayList<ParkingSpot> availables = parkingLot.availableSpots(VehicleType.CAR);
        System.out.println(parkingLot.isFull(VehicleType.CAR)); //false
        System.out.println(availables.size()); //1
        Vehicle v = new Vehicle("BD123", VehicleType.CAR);
        ParkingSpot s = availables.get(0);
        parkingLot.parkVehicle(v, s);
        System.out.println(parkingLot.isFull(VehicleType.CAR)); //true
        parkingLot.vacateSpot(s);
        System.out.println(parkingLot.isFull(VehicleType.CAR)); //false
    }
}