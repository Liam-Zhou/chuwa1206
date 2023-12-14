package com.chuwa.learn.javacore.Builder;

public class Client {
        public static void main(String[] args) {
                Director director = new Director(new MobikeBuilder());

                Bike bike = director.buildBike();

                System.out.println(bike.getFrame());
        }
}
