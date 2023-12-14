package com.chuwa.learn.pattern.singleton;


//eager load
public class SingletonEager {
    private SingletonEager(){}
    private static SingletonEager instance = new SingletonEager();
    public static SingletonEager getInstance() {
        return instance;
    }
}

