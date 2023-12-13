package org.example.builder;

public class OfoBuilder extends Builder{

    @Override
    public void buildFrame() {
        bike.setSeat("Steel");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Rubber");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
