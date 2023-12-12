package chuwa.hw2;

import chuwa.hw2.exception.InvalidVehicleNumberException;
import chuwa.hw2.exception.ParkingFullException;
import chuwa.hw2.model.Ticket;
import chuwa.hw2.model.Vehicle;
import chuwa.hw2.model.VehicleSize;
import chuwa.hw2.service.ParkingLot;
import chuwa.hw2.strategy.FourWheelerWeekDayChargeStrategy;
import chuwa.hw2.strategy.TwoWheelerWeekDayChargeStrategy;

public class Main {
    public static void main(String[] args) throws ParkingFullException {
        ParkingLot parkingLot = ParkingLot.getParkingLot();

        parkingLot.initializeParkingSlots(10, 10);

        Vehicle vehicle = new Vehicle("Mh12", VehicleSize.TWOWHEELER);

        Ticket ticket = parkingLot.park(vehicle);
        System.out.println(ticket);

        Vehicle vehicle2 = new Vehicle("Mh13", VehicleSize.FOURWHEELER);

        Ticket ticket2 = parkingLot.park(vehicle2);
        System.out.println(ticket2);

        int cost1, cost2 = -1;
        try {
            cost1 = parkingLot.unPark(ticket, new TwoWheelerWeekDayChargeStrategy());
        } catch (InvalidVehicleNumberException e) {
            throw new RuntimeException(e);
        }
        System.out.println(cost1);

        try {
            cost2 = parkingLot.unPark(ticket2, new FourWheelerWeekDayChargeStrategy());
        } catch (InvalidVehicleNumberException e) {
            throw new RuntimeException(e);
        }
        System.out.println(cost2);

    }
}