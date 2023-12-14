package pattern.singleton.demo4;

/**
 * @author xiaorui
 *
 * Lazy load
 *
 * 双重检查锁
 */
public class Singleton {
    private Singleton() {}

    private static volatile Singleton instance;

    public static Singleton getInstance() {
        // 第一次判读
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
