package pattern.singleton.demo1;

/**
 * @author xiaorui
 *
 * Eager load pattern 2
 */
public class Singleton {
    private Singleton() {}

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
