package com.chuwa.service;

import com.chuwa.exception.InvalidVehicleNumberException;
import com.chuwa.exception.ParkingFullException;
import com.chuwa.model.Ticket;
import com.chuwa.model.Vehicle;
import com.chuwa.strategy.ParkingChargeStrategy;

public interface Parking {
    public Ticket park(Vehicle vehicle) throws ParkingFullException;

    public int unPark(Ticket ticket, ParkingChargeStrategy parkingCostStrategy) throws InvalidVehicleNumberException;
}
