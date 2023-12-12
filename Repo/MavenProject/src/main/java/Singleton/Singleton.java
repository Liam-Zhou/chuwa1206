package Singleton;

// https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
public class Singleton {
    private Singleton(){}

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
