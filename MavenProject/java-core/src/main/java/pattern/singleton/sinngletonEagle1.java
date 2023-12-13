package pattern.singleton;

public class sinngletonEagle1 {
    private static SingletonEager1 instance = new SingletonEager1();

    private SingletonEager1() {
        System.out.println("Singleton instance created");
    }

    public static SingletonEager1 getInstance() {
        return instance;
    }
}
