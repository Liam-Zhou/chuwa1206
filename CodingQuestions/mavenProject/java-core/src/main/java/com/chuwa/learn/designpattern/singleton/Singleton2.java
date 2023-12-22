package com.chuwa.learn.designpattern.singleton;


/**
 * eager load: method 2
 */
public class Singleton2 {

    // private constructor, cannot be accessed by external files
    private Singleton2(){}

    private static Singleton2 instance; // null

    // 在静态代码中进行赋值
    static {
        instance = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return instance;
    }
}
