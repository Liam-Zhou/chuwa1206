package pattern.singleton;
// Lazy Load: 静态内部类方式
    // 由于jvm在加载外部类的过程中，是不会加载静态内部类的，只有内部类的属性/方法被调用时才会被加载，并初始化其静态属性。
    // 静态属性由于被Static修饰，保证只被实例化一次, 并且严格保证实例化顺序。（避免JVM在实例化对象的时候会进行优化和指令重排序操作）
public class LazyLoadSingletonDemo3 {
    // 1. 私有构造方法
    private LazyLoadSingletonDemo3(){}

    // 2. 定义一个静态内部类
    private static class SingletonHolder {
        // 在内部类中声明并初始化外部类的对象
        private static final LazyLoadSingletonDemo3 INSTANCE = new LazyLoadSingletonDemo3();
    }

    // 3. 提供公共的访问方式，供外界获取访问对象
    public static LazyLoadSingletonDemo3 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
