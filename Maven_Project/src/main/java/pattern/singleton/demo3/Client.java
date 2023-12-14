package pattern.singleton.demo3;

/**
 * @program: Maven_Project
 * @ClassName Client
 * @description:
 * @author: Zhenwei Dai
 * @create: 2023-12-13 17:03
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);
    }
}