package pattern.singleton.demo1;

/**
 * @program: Maven_Project
 * @ClassName Client
 * @description:
 * @author: Zhenwei Dai
 * @create: 2023-12-13 16:35
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        //create Singleton Obj
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1 == instance2);
    }
}