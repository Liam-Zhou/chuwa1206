package org.example;

import org.example.builder.Bike;
import org.example.builder.Director;
import org.example.builder.MobileBuilder;
import org.example.singleton.Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);

        Director director = new Director(new MobileBuilder());
        Bike bike = director.construct();
        System.out.println(bike.getFrame() + " " + bike.getSeat());
    }
}