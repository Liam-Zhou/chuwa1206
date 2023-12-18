package com.chuwa.learn;

public class Main {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();
        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();
        Vehicle bus = new Bus();

        System.out.println("Parking a car: " + lot.parkVehicle(car));       // 应该返回 true
        System.out.println("Parking a motorcycle: " + lot.parkVehicle(motorcycle)); // 应该返回 true
        System.out.println("Parking a bus: " + lot.parkVehicle(bus));      // 根据停车场的配置，可能返回 true 或 false
    }
}
