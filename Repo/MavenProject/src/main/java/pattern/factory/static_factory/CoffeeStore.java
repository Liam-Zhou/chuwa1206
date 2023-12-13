package pattern.factory.static_factory;

public class CoffeeStore {
    public Coffee orderCoffee(String type) {

        Coffee coffee = SimpleCoffeeFactory.createCoffee(type);

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
