package com.chuwa.tutorial.t01_basic.zhaokuan_chen_generic;

public class GenericClassTest {
    public static void main(String[] args) {
        GenericClass<String> obj = new GenericClass<>("Hello World");
        System.out.println(obj.getObj());

        GenericClass<Integer> obj1 = new GenericClass<>(10);
        System.out.println(obj1.getObj());

        GenericClass<Double> obj2 = new GenericClass<>(20.0);
        System.out.println(obj2.getObj());
    }
}
