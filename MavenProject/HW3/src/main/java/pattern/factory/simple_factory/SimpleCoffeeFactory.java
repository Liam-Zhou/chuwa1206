package pattern.factory.simple_factory;

/**
 * @author xiaorui
 */
public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type) {
        Coffee coffee = null;
        if ("Americano".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("Latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("No this Coffee.");
        }

        return coffee;
    }
}
