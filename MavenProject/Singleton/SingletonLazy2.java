package Singleton;

public class SingletonLazy2 {
    private static SingletonLazy2 instance;

    private SingletonLazy2() {
        System.out.println("Singleton instance created");
    }

    public static SingletonLazy2 getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy2.class) {
                if (instance == null) {
                    instance = new SingletonLazy2();
                }
            }
        }
        return instance;
    }
}
