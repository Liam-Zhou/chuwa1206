package Singleton;

public class SingletonLazy2 {
    private static SingletonLazy2 instance;

    private SingletonLazy2() {
        System.out.println("Singleton instance created");
    }

    public static SingletonLazy2 getInstance() {
        //thread can enter to here, if instance is not null, can be faster
        if (instance == null) {
            //have to lock here, if instance is null, only one thread can enter to here
            synchronized (SingletonLazy2.class) {
                if (instance == null) {
                    instance = new SingletonLazy2();
                }
            }
        }
        return instance;
    }
}
