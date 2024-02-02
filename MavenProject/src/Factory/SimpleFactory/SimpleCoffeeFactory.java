package Factory.SimpleFactory;

public class SimpleCoffeeFactory {

    public Coffee createCoffee(String type) {
        Coffee coffee = null;
        if (type == "latte") {
            coffee = new LatteCoffee();
        } else if (type == "American") {
            coffee = new AmericanCoffee();
        } else {
            throw new RuntimeException("The coffee is not available!");
        }
        return coffee;
    }
}
