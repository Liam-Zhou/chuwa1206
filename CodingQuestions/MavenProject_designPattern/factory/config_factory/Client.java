package MavenProject_designPattern.factory.config_factory;

public class Client {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.createCoffee("american");
        System.out.println(coffee.getName());

        System.out.println("=============");
        Coffee latte = CoffeeFactory.createCoffee("latte");
        System.out.println(latte.getName());

        System.out.println("=============");
        Coffee chuwaCoffee = CoffeeFactory.createCoffee("chuwa");
        System.out.println(chuwaCoffee.getName());
    }
}
