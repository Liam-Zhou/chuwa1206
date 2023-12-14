package MavenProject_designPattern.singletone.egaer.staticeBlock;

/**
 * 饿汉-静态代码块
 */
public class Singletone {
    public Singletone() {
    }
    //声明单例类型的变量
    private static Singletone instance;

    //在静态代码块中赋值
    static {
        instance = new Singletone();
    }
    public static Singletone getInstance() {
        return instance;
    }
}
