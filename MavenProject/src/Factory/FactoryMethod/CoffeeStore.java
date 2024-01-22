package Factory.FactoryMethod;

import Factory.SimpleFactory.SimpleCoffeeFactory;

public class CoffeeStore {

    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee() {
        Coffee coffee = factory.createCoffee();
        coffee.addmilk();
        coffee.addsugar();
        return coffee;
    }
}
