package com.chuwa.tutorial.t01_basic.zhaokuan_chen_generic;

public class GenericMultiArguments {
    public static <T1, T2, T3> void temp(T1 x, T2 y, T3 z) {
        System.out.println("This is x = " + x);
        System.out.println("This is y = " + y);
        System.out.println("This is z = " + z);
    }

    public static void main(String[] args) {
        temp(3, "5", 60.2);
    }
}
