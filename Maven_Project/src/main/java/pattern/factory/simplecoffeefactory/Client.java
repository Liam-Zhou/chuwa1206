package pattern.factory.simplecoffeefactory;

/**
 * @program: Maven_Project
 * @ClassName Client
 * @description:
 * @author: Zhenwei Dai
 * @create: 2023-12-13 19:53
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("latte");

        System.out.println(coffee.getName());
    }
}