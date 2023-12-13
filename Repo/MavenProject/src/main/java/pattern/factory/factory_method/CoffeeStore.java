package pattern.factory.factory_method;

public class CoffeeStore {

    private CoffeeFactory coffeeFactory;

    public void setFactory(CoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }
    public Coffee orderCoffee() {
        Coffee coffee = coffeeFactory.createCoffee();

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
