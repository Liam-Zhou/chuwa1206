package DesignPattern.Factory.SimpleFactory;

public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("Latte");
        System.out.println(coffee.getName());
    }
}
