package pattern.singleton;
// Laze Load: 双重检查锁方式
public class LazyLoadSingletonDemo2 {
    // 1. 私有构造方法
    private LazyLoadSingletonDemo2() {}

    // 2. 声明Singleton类型的变量
    private static volatile LazyLoadSingletonDemo2 instance;

    // 3. 对外提供公共的访问方式
    public static LazyLoadSingletonDemo2 getInstance() {
        // 第一次判断，如果instance的值不为null, 不需要抢占锁, 直接返回对象
        if (instance == null) {
            synchronized (LazyLoadSingletonDemo2.class) {
                // 第二次判断
                if (instance == null) {
                    instance = new LazyLoadSingletonDemo2();
                }
            }
        }
        return instance;
    }
}
