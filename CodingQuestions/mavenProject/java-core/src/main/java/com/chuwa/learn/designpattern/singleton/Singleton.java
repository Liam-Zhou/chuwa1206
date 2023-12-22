package com.chuwa.learn.designpattern.singleton;

/**
 * eager load: method 1
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton(){

    }

    public static  Singleton getInstance(){
        return instance;
    }
}
