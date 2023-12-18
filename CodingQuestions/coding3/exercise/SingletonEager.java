public class SingletonEager {
    private static SingletonEager eager = new SingletonEager();
    private SingletonEager() {};
    public static synchronized SingletonEager getInstance() {
        return eager;
    }
}

