package com.java.singleton;

public class SingletonLazy3 {
    private SingletonLazy3(){};

    private static class SingletonHolder{
        private static final SingletonLazy3 INSTANCE =new SingletonLazy3();
    }

    public static SingletonLazy3 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
