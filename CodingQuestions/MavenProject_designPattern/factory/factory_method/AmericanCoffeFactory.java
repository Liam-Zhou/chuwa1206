package MavenProject_designPattern.factory.factory_method;


public class AmericanCoffeFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
