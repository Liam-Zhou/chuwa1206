package com.chuwa.DefaultInterfaceMethod;

public interface Base {
    static final String s = "abc";

    abstract int add(int a, int b);

    default public int substract(int a, int b){
        return a - b;
    }
}
