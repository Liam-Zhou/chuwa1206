package DesignPattern.Singleton.LazyLoadSingleton2;

public class Singleton {
    private Singleton() {};
    private static Singleton instance;
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) { //request a lock
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
