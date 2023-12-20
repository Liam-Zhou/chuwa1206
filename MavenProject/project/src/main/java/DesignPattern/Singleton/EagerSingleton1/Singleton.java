package DesignPattern.Singleton.EagerSingleton1;

/**
 * EagerSingleton
 * Static local variable
 */
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){};

    public static Singleton getInstance() {
        return instance;
    }
}