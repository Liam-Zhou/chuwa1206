package pattern.singleton.demo1;

/**
 * Eager static
 */
public class Singleton {

    private Singleton() {}

    private static final Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
