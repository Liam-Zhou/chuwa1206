package com.chuwa.learn.javacore.Builder;

public abstract class Builder {
        protected Bike bike = new Bike();

        public abstract void buildFrame();

        public abstract void buildSeat();

        // method to build bike
        public abstract Bike createBike();

        // can put buildBike() here if simple, and cancel director
}
