package pattern.singleton.demo8;

import java.lang.reflect.Constructor;

/**
 * Destroy Singleton using reflection
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // 1. 获取singleton的字节码对象
        Class singletonClass = Singleton.class;
        // 2. 获取无参构造方法对象
        Constructor cons = singletonClass.getDeclaredConstructor();
        // 3. 取消访问检查
        cons.setAccessible(true);
        // 4. 创建Singleton对象
        Singleton s1 = (Singleton) cons.newInstance();
        Singleton s2 = (Singleton) cons.newInstance();
        System.out.println(s1 == s2); // return false
    }
}
