package com.java.singleton;

public class SingletonLazy2 {

    private SingletonLazy2(){};

    private static volatile SingletonLazy2 instance;

    public static SingletonLazy2 getInstance(){
        if(instance==null){
            synchronized (SingletonLazy2.class){
                if(instance==null){
                    instance=new SingletonLazy2();
                }
            }
        }
        return instance;
    }
}
