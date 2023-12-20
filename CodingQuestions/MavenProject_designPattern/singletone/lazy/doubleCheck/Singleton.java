package MavenProject_designPattern.singletone.lazy.doubleCheck;

/**
 * double ckeck 模式有可能会出现空指针. 因为cpu会出现指令重排, 所以需要volatile
 *
 */
public class Singleton {
    private Singleton(){}
    //声明单例类型的变量, 不赋值
    private static volatile Singleton instance;
    public static Singleton getInstance() {
        if (instance == null) {//如果不为null, 不需要抢占锁, 提升性能.
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
