package pattern.singleton.destroy.serialize;

import pattern.singleton.LazyLoadSingletonDemo3;

import java.io.Serializable;

public class Singleton implements Serializable {
    // 1. 私有构造方法
    private Singleton(){}

    // 2. 定义一个静态内部类
    private static class SingletonHolder {
        // 在内部类中声明并初始化外部类的对象
        private static final Singleton INSTANCE = new Singleton();
    }

    // 3. 提供公共的访问方式，供外界获取访问对象
    public static Singleton getInstance() {
        return Singleton.SingletonHolder.INSTANCE;
    }
}
