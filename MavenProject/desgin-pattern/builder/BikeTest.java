package com.java.builder;

public class BikeTest {
    public static void main(String[] args){
        Director director=new Director(new MobileBuilder());

        Bike bike=director.construct();

        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}
