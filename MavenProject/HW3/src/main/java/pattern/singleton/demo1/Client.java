package pattern.singleton.demo1;

/**
 * @author xiaorui
 */
public class Client {
    public static void main(String[] args) {
        // 创建Singleton类的对象
        Singleton instance = Singleton.getInstance();

        Singleton instance2 = Singleton.getInstance();

        // 判断是否为同一对象
        System.out.println(instance == instance2);
    }
}
