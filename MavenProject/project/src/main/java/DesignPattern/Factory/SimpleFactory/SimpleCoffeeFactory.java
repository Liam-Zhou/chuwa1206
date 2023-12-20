package DesignPattern.Factory.SimpleFactory;

public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type) {
        Coffee coffee;
        if (type.equals("Americano")) {
            coffee = new Americano();
        } else if (type.equals("Latte")) {
            coffee = new Latte();
        } else {
            throw new RuntimeException("No such coffee");
        }
        return coffee;
    }
}
