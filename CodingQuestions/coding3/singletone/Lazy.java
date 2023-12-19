package coding3.singletone;

/**
 * 静态内部类初始化的时候不会被加载, 所以是lazy
 */
public class Lazy {
    private static class SingletonHolder {
        private static final Lazy instance = new Lazy();
    }
    private Lazy(){}
    public static Lazy getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        Lazy instance1 = Lazy.getInstance();
        Lazy instance2 = Lazy.getInstance();
        System.out.println(instance1);
        System.out.println(instance1);
    }
}
