package com.chuwa.learn.javacore.Builder;

public class MobikeBuilder extends Builder {

        @Override
        public void buildFrame() {
                bike.setFrame("Carbon");
        }

        @Override
        public void buildSeat() {
                bike.setSeat("leather");
        }

        @Override
        public Bike createBike() {
                return bike;
        }
}
