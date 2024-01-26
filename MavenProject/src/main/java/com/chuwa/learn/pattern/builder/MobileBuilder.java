package com.chuwa.learn.pattern.builder;

public class MobileBuilder extends Builder {
    public void buildFrame() {
        bike.setFrame("Alu Frame");
    }

    public void buildSeat() {
        bike.setSeat("Alu Seat");
    }

    public void buildTire() {
        bike.setTire("Alu Tire");
    }

    public Bike createBike() {
        return bike;
    }
}
