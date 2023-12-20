package Singleton;

public class SingletonLazy {
    private SingletonLazy() {}

    private static class SingletonHolder {
        private static final SingletonLazy INSTANCE = new SingletonLazy();
    }

    public static SingletonLazy getInstance() {
        System.out.println("lazy load instance");
        return SingletonHolder.INSTANCE;
    }
}
