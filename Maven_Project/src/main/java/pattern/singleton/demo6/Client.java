package pattern.singleton.demo6;

/**
 * @program: Maven_Project
 * @ClassName Client
 * @description:eager load ： enum, the best way of eager load
 * @author: Zhenwei Dai
 * @create: 2023-12-13 17:49
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;

        System.out.println(instance1 == instance2);
    }
}