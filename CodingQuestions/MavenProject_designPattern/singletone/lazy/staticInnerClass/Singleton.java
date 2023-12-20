package MavenProject_designPattern.singletone.lazy.staticInnerClass;

/**
 * 因为jvm初始化的时候不会初始化静态内部类, 所以利用这个特点来单例.
 *
 * 静态内部类方式, 比较推荐. 简单 性能好.
 * 优点: 在不加锁的情况下保证了线程安全
 *
 */
public class Singleton {
    private Singleton() {
    }
    private static class SingletoneHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() {
        return SingletoneHolder.INSTANCE;
    }
}
