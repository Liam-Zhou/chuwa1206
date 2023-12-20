package pattern.singleton.demo5;

/**
 * @author xiaorui
 *
 * 静态内部类方式
 */
public class Singleton {
    private Singleton() {}

    // 定义一个静态内部类
    private static class SingletonHolder {
        // 在内部类中声明并初始化外部类的对象
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
