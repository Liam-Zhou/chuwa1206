package pattern.singleton.demo3;

/**
 * @author xiaorui
 *
 * Lazy load: thread-safe
 *
 */
public class Singleton {
    private Singleton() {}

    private static Singleton instance;

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
