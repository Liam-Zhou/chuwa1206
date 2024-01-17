package Singleton;

public class SingletonLazy1 {
    private static SingletonLazy1 instance;

    private SingletonLazy1() {
        System.out.println("Singleton instance created");
    }

    public static synchronized SingletonLazy1 getInstance() {
        if (instance == null) {
            instance = new SingletonLazy1();
        }
        return instance;
    }
}
