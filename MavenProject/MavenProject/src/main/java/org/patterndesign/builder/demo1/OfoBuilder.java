package org.patterndesign.builder.demo1;

public class OfoBuilder extends Builder {
    public void buildFrame() {
        bike.setFrame("lvhejin-frame");
    }

    public void buildSeat() {
        bike.setSeat("xiangjiao-seat");
    }

    public Bike createBike() {
        return bike;
    }
}
