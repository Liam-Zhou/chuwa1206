package org.patterndesign.singleton.demo4;

public class Singleton {

    private Singleton() {}

    private static Singleton instance; //null

    //在静态代码块中进行赋值
    static {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }
}
