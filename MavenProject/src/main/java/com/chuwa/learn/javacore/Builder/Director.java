package com.chuwa.learn.javacore.Builder;

public class Director {
        private Builder builder;

        public Director(Builder builder) {
                this.builder = builder;
        }

        // build the bike
        public Bike buildBike() {
                builder.buildFrame();
                builder.buildSeat();
                return builder.bike;
        }
}
