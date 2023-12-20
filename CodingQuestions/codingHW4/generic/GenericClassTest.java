package com.chuwa.tutorial.t01_basic.generic;

/**
 * @author b1go
 * @date 7/25/22 12:18 AM
 */
public class GenericClassTest {

    public static void main(String[] args) {
        // Test for Integer type
        GenericClass<Integer> obj1 = new GenericClass<>(10);
        System.out.println(obj1.getObj());

        // Test for double type
        GenericClass<Double> obj2 = new GenericClass<>(13.2705);
        System.out.println(obj2.getObj());

        // Test for String type
        GenericClass<String> obj3 = new GenericClass<>("Hello World!");
        System.out.println(obj3.getObj());
    }
}
