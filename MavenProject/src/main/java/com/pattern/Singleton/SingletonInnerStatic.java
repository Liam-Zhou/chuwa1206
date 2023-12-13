package com.pattern.Singleton;

public class SingletonInnerStatic {

    private SingletonInnerStatic() {
        System.out.println("Singleton instance created");
    }
    private static class SingletonHolder {
        private static final SingletonInnerStatic INSTANCE = new SingletonInnerStatic();
    }

    public static SingletonInnerStatic getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
