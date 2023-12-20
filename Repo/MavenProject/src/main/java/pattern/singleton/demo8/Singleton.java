package pattern.singleton.demo8;

public class Singleton {

    private static boolean flag = false;

    private Singleton() {
        synchronized (Singleton.class) {
            // 判断flag的值是否是true，如果是true，说明非第一次访问，直接抛一个异常
            // 如果false，说明第一次访问
            if (flag) {
                throw new RuntimeException("Cannot create multiple instances");
            }
            flag = true;
        }
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
