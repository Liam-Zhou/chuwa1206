package chuwa.hw2.service;

import chuwa.hw2.exception.InvalidVehicleNumberException;
import chuwa.hw2.exception.ParkingFullException;
import chuwa.hw2.model.Ticket;
import chuwa.hw2.model.Vehicle;
import chuwa.hw2.strategy.ParkingChargeStrategy;

// part and unpark vehicle
public interface Parking {
    public Ticket park(Vehicle vehicle) throws ParkingFullException;

    public int unPark(Ticket ticket, ParkingChargeStrategy parkingCostStrategy) throws InvalidVehicleNumberException;

}
