package Singleton;

public class SingletonInnerStaticClass {

    private SingletonInnerStaticClass() {
        System.out.println("Singleton instance created");
    }
    private static class SingletonHolder {
        private static final SingletonInnerStaticClass INSTANCE = new SingletonInnerStaticClass();
    }

    public static SingletonInnerStaticClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
