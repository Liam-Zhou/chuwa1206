package Singleton;

public class SingletonEager2 {
    private static SingletonEager2 instance; //not initialized yet

    static {
        instance = new SingletonEager2();
    }

    private SingletonEager2() {
        System.out.println("Singleton instance created");
    }

    public static SingletonEager2 getInstance() {
        return instance;
    }
}
