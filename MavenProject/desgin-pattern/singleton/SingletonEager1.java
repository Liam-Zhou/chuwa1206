package com.java.singleton;

public class SingletonEager1 {
    private SingletonEager1(){};

    private static SingletonEager1 instance = new SingletonEager1();

    public static SingletonEager1 getInstance(){
        return instance;
    }
}
