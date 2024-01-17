package pattern.Factory;

public class SimpleCoffeeFactory {

        public Coffee createCoffee(String type) {
            Coffee coffee = null;
            if ("american".equals(type)) {
                coffee = new AmericanCoffee();
            } else if ("latte".equals(type)) {
                coffee = new LatteCoffee();
                // case ...
            } else {
                throw new UnsupportedOperationException("unknown coffee type：");
            }
            return coffee;
        }
}
