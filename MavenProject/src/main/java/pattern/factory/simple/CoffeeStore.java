package pattern.factory.simple;


public class CoffeeStore {

    public Coffee orderCoffee(String type) {

        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        Coffee coffee = factory.createCoffee(type);

        coffee.addMilke();
        coffee.addSuger();
        return coffee;
    }
}
