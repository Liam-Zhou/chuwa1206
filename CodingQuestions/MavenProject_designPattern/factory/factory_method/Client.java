package MavenProject_designPattern.factory.factory_method;

public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        CoffeeFactory factory = new AmericanCoffeFactory();
        store.setFactory(factory);
        System.out.println(store.orderCoffee().getName());
    }
}
