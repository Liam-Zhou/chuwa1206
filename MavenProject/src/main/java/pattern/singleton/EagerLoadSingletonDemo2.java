package pattern.singleton;
// Eager load: 类加载就会导致该单实例对象被创建
// 静态代码块方式创建
public class EagerLoadSingletonDemo2 {
    // 1.私有构造方法
    private  EagerLoadSingletonDemo2() {

    }

    // 2. 声明Singleton类型的变量
    private static EagerLoadSingletonDemo2 instance; // null

    // 在静态代码块中进行赋值
    static {
        instance = new EagerLoadSingletonDemo2();
    }
    //3. 提供一个公共的访问方式，让外界获取该对象
    public static EagerLoadSingletonDemo2 getInstance() {
        return instance;
    }
}
