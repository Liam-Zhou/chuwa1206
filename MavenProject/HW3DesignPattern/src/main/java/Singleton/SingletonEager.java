package Singleton;

public class SingletonEager {
    private SingletonEager() {}

    private static final SingletonEager INSTANCE = new SingletonEager();

    public static SingletonEager getInstance() {
        System.out.println("eager singleton");
        return INSTANCE;
    }
}
