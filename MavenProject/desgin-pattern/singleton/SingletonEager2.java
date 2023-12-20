package com.java.singleton;

public class SingletonEager2 {
    private SingletonEager2(){};

    private static SingletonEager2 instance;

    static {
        instance=new SingletonEager2();
    }

    public static SingletonEager2 getInstance(){
        return instance;
    }
}
