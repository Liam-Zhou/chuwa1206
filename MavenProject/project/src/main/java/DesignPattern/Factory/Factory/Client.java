package DesignPattern.Factory.Factory;


public class Client {
    public static void main(String[] args) {
        CoffeeFactory factory = new AmericanoFactory();
        CoffeeStore store = new CoffeeStore();
        store.setFactory(factory);
        Coffee coffee = store.orderCoffee();
        System.out.println(coffee.getName());
    }
}
