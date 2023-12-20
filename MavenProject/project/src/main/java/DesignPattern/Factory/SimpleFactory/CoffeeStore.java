package DesignPattern.Factory.SimpleFactory;

public class CoffeeStore {

    public Coffee orderCoffee(String type) {
        SimpleCoffeeFactory coffeeFactory = new SimpleCoffeeFactory();
        Coffee coffee = coffeeFactory.createCoffee(type);
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
