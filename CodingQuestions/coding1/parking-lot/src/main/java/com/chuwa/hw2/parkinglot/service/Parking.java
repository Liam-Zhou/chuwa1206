package com.chuwa.hw2.parkinglot.service;

import com.chuwa.hw2.parkinglot.exception.InvalidVehicleNumberException;
import com.chuwa.hw2.parkinglot.exception.ParkingFullException;
import com.chuwa.hw2.parkinglot.model.Ticket;
import com.chuwa.hw2.parkinglot.model.Vehicle;
import com.chuwa.hw2.parkinglot.strategy.ParkingChargeStrategy;

public interface Parking {

    public Ticket park(Vehicle vehicle) throws ParkingFullException;

    public int unPark(Ticket ticket, ParkingChargeStrategy parkingCostStrategy) throws InvalidVehicleNumberException;
}