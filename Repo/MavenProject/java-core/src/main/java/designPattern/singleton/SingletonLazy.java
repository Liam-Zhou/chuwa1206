package designPattern.singleton;

public class SingletonLazy {
    private  static SingletonLazy instance;
    private SingletonLazy() {
        System.out.println("Singleton instance created");
    }

    public static synchronized SingletonLazy getInstance() {
        if(instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

}
