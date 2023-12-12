package chuwa.hw2.service;

import chuwa.hw2.exception.InvalidVehicleNumberException;
import chuwa.hw2.exception.ParkingFullException;
import chuwa.hw2.model.Slot;
import chuwa.hw2.model.Ticket;
import chuwa.hw2.model.Vehicle;
import chuwa.hw2.model.VehicleSize;
import chuwa.hw2.strategy.ParkingChargeStrategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingLot implements Parking{

    private static ParkingLot parkingLot;
    private final List<Slot> twoWheelerSlots;
    private final List<Slot> fourWheelerSlots;

    // singleton object
    private ParkingLot() {
        this.twoWheelerSlots = new ArrayList<>();
        this.fourWheelerSlots = new ArrayList<>();
    }

    public static ParkingLot getParkingLot() {
        if (parkingLot == null)
            parkingLot = new ParkingLot();
        return parkingLot;
    }

    public boolean initializeParkingSlots(int numberOfTwoWheelerParkingSlots, int numberOfFourWheelerParkingSlots) {

        for (int i = 1; i <= numberOfTwoWheelerParkingSlots; i++) {
            twoWheelerSlots.add(new Slot(i));
        }

        System.out.printf("Created a two wheeler parking lot with %s slots %n", numberOfTwoWheelerParkingSlots);

        for (int i = 1; i <= numberOfFourWheelerParkingSlots; i++) {
            fourWheelerSlots.add(new Slot(i));
        }

        System.out.printf("Created a four wheeler parking lot with %s slots %n", numberOfFourWheelerParkingSlots);
        return true;
    }

    public Ticket park(Vehicle vehicle) throws ParkingFullException {
        Slot nextAvailableSlot;
        if (vehicle.getVehicleSize().equals(VehicleSize.FOURWHEELER)) {
            nextAvailableSlot = getNextAvailableFourWheelerSlot();
        } else {
            nextAvailableSlot = getNextAvailableTwoWheelerSlot();
        }
        nextAvailableSlot.occupySlot(vehicle);
        System.out.printf("Allocated slot number: %d \n", nextAvailableSlot.getSlotNumber());
        Ticket ticket = new Ticket(nextAvailableSlot.getSlotNumber(), vehicle.getVehicleNumber(),
                vehicle.getVehicleSize(), new Date());
        return ticket;
    }

    // simple iteration based parking strategy
    private Slot getNextAvailableFourWheelerSlot() throws ParkingFullException {
        for (Slot slot : fourWheelerSlots) {
            if (slot.isEmpty()) {
                return slot;
            }
        }
        throw new ParkingFullException("No Empty Slot available");
    }

    private Slot getNextAvailableTwoWheelerSlot() throws ParkingFullException {
        for (Slot slot : twoWheelerSlots) {
            if (slot.isEmpty()) {
                return slot;
            }
        }
        throw new ParkingFullException("No Empty Slot available");
    }

    public int unPark(Ticket ticket, ParkingChargeStrategy parkingCostStrategy) throws InvalidVehicleNumberException {
        int costByHours = 0;
        Slot slot;
        try {
            if (ticket.getVehicleSize().equals(VehicleSize.FOURWHEELER)) {
                slot = getFourWheelerSlotByVehicleNumber(ticket.getVehicleNumber());
            } else {
                slot = getTwoWheelerSlotByVehicleNumber(ticket.getVehicleNumber());
            }
            slot.vacateSlot();
            int hours = getHoursParked(ticket.getDate(), new Date());
            costByHours = parkingCostStrategy.getCharge(hours);
            System.out.println(
                    "Vehicle with registration " + ticket.getVehicleNumber() + " at slot number " + slot.getSlotNumber()
                            + " was parked for " + hours + " hours and the total charge is " + costByHours);
        } catch (InvalidVehicleNumberException invalidVehicleNumber) {
            System.out.println(invalidVehicleNumber.getMessage());
            throw invalidVehicleNumber;
        }
        return costByHours;
    }

    private int getHoursParked(Date startDate, Date endDate) {
        long secs = (endDate.getTime() - startDate.getTime()) / 1000;
        int hours = (int) (secs / 3600);
        return hours;

    }

    private Slot getFourWheelerSlotByVehicleNumber(String vehicleNumber) throws InvalidVehicleNumberException {
        for (Slot slot : fourWheelerSlots) {
            Vehicle vehicle = slot.getParkVehicle();
            if (vehicle != null && vehicle.getVehicleNumber().equals(vehicleNumber)) {
                return slot;
            }
        }
        throw new InvalidVehicleNumberException("Two wheeler with registration number " + vehicleNumber + " not found");
    }

    private Slot getTwoWheelerSlotByVehicleNumber(String vehicleNumber) throws InvalidVehicleNumberException {
        for (Slot slot : twoWheelerSlots) {
            Vehicle vehicle = slot.getParkVehicle();
            if (vehicle != null && vehicle.getVehicleNumber().equals(vehicleNumber)) {
                return slot;
            }
        }
        throw new InvalidVehicleNumberException("Two wheeler with registration number " + vehicleNumber + " not found");
    }
}
