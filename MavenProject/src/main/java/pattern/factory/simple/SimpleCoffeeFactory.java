package pattern.factory.simple;
import pattern.factory.simple.Coffee;
import pattern.factory.simple.AmericanCoffee;
import pattern.factory.simple.LatteCoffee;

public class SimpleCoffeeFactory {

    public Coffee createCoffee(String type) {
        Coffee coffee = null;
        if("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("Sorry, we dont have it");
        }

        return coffee;
    }
}
