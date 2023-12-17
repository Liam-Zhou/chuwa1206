package pattern.factory.simple_factory;


public class CoffeeStore {
    public Coffee orderCoffee(String type){
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        Coffee coffee = factory.creatCoffee(type);
        coffee.addsugar();;
        coffee.addMilk();
        return coffee;
    }
}
