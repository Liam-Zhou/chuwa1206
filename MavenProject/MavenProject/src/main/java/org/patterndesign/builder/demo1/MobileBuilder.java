package org.patterndesign.builder.demo1;

public class MobileBuilder extends Builder {
    public void buildFrame() {
        bike.setFrame("tanxianwei-frame");
    }

    public void buildSeat() {
        bike.setSeat("zhenpi");
    }

    public Bike createBike() {
        return bike;
    }
}
