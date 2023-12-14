package pattern.builder;

/**
 * @program: Maven_Project
 * @ClassName Client
 * @description:
 * @author: Zhenwei Dai
 * @create: 2023-12-13 23:14
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        Director director = new Director(new MobikeBuilder());

        Bike bike = director.construct();

        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}