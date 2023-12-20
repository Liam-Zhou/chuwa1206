package pattern.singleton;
// Lazy Load: 线程不安全，类加载不会导致该单实例对象被创建，而是首次使用该对象时才会创建

public class LazyLoadSingletonDemo1 {
    // 1. 私有构造方法
    private LazyLoadSingletonDemo1(){}

    // 2. 声明Singleton类型的变量instance
    private static LazyLoadSingletonDemo1 instance; // 只是声明了一个变量，并没有进行赋值

    // 3. 对外提供访问方式

    public static LazyLoadSingletonDemo1 getInstanceThreadUnsafe() {
        // 为了保证只创建一次，所以要判断instance之前是否赋值过
            // 为什么线程不安全？
        if (instance == null) {
            // thread1: wait
            // thread2: wait, 因为thread1进入后未创建就进入等待了，因此两个线程会分别创建
            instance = new LazyLoadSingletonDemo1();
        }
        return instance;
    }
        // 线程安全版本
    public static synchronized LazyLoadSingletonDemo1 getInstanceThreadSafe() {
        // 为了保证只创建一次，所以要判断instance之前是否赋值过
        if (instance == null) {
            // thread 1 等待，thread2获取cpu执行权，由于同步锁的存在，所以Thread2没办法进入这个程序
            instance = new LazyLoadSingletonDemo1();
        }
        return instance;
    }
}

