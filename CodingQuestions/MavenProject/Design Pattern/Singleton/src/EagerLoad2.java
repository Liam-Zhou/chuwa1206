/**
 * @Description: 静态代码块
 */
public class EagerLoad2 {
    private EagerLoad2() {

    }
    //只是声明变量
    private static EagerLoad2 instance;

    //静态代码块中赋值
    static {
        instance = new EagerLoad2();
    }

    public static EagerLoad2 getInstance() {
        return instance;
    }
}
