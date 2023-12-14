package MavenProject_designPattern.factory.simple_factory;


public class Client {
    public static void main(String[] args) {
        //创建咖啡店类对象
        CoffeeStore store = new CoffeeStore();
        Coffee coffee1 = store.orderCoffee("latte");
        Coffee coffee2 = store.orderCoffee("american");

        System.out.println(coffee1.getName());
        System.out.println(coffee2.getName());
    }
}
