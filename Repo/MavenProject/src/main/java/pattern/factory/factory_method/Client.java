package pattern.factory.factory_method;

public class Client {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        CoffeeFactory coffeeFactory = new LatteCoffeeFactory();
        coffeeStore.setFactory(coffeeFactory);

        Coffee coffee = coffeeStore.orderCoffee();
        System.out.println(coffee.getName());
    }
}
