package pattern.singleton;
// Eager load: 类加载就会导致该单实例对象被创建
// 静态成员变量方式创建
public class EagerLoadSingletonDemo1 {
    // 1. 私有构造方法
    private EagerLoadSingletonDemo1() {}

    // 由于构造器私有化，因此在该类中创建一个对象供外界使用
    // 2. 在本类中创建该类对象
    private static EagerLoadSingletonDemo1 instance = new EagerLoadSingletonDemo1();

    // 3. 提供一个公共的访问方式，让外界获取该对象
        // 因为外界无法创建本类，所以需要使用Static方法来让外部调用该类中的方法
    public static EagerLoadSingletonDemo1 getInstance() {
        return instance;
    }

}
