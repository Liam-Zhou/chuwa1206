package com.chuwa.Main;

import com.chuwa.parkinglot.ParkingLot;
import com.chuwa.vehicles.*;
public class Main{
    public static void main(String[] args){
        ParkingLot mylot = new ParkingLot();
        Car car1 = new Car("123");
        System.out.println(car1.getPlate());
        Car car2 = new Car("abc");
        Car car3 = new Car("1q2w");

        // event sequence
        mylot.park(car1); //Car 123 parks at slot 0
        mylot.park(car2); //Car abc parks at slot 1
        mylot.leave(1); //Car abc at slot 1 leave
        mylot.park(car3); //Car 1q2w parks at slot 2
        mylot.leave(5); //No car leave.
        mylot.leave(2); //Car 1q2w at slot 2 leave
        mylot.leave(0); //Car 123 at slot 0 leave
    }
}
