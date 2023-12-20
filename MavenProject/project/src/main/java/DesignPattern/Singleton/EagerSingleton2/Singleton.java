package DesignPattern.Singleton.EagerSingleton2;

/**
 * EagerSingleton
 * Static local variable
 */
public class Singleton {
    private static Singleton instance;

    private Singleton(){};

    static {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }
}
