package Factory.FactoryMethod;

public class Client {
    public static void main(String[] args) {
        CoffeeStore cs = new CoffeeStore();
        cs.setFactory(new LatteCoffeeFactory());

        Coffee coffee = cs.orderCoffee();
        System.out.println(coffee.getName());
    }
}
