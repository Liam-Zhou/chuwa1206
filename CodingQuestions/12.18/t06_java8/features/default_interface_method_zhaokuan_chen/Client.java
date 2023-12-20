package com.chuwa.tutorial.t06_java8.features.default_interface_method_zhaokuan_chen;

public class Client {
    public static void main(String[] args) {
        DIML dim = new DIMImpl();
        System.out.println("Override method: " + dim.add(1, 2));
        System.out.println("Default method: " + dim.subtract(5,0));
        System.out.println("Static method: " + DIML.function());
    }
}
