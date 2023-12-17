package pattern.factory.static_factory;


public class CoffeeStore {
    public Coffee orderCoffee(String type){
        //SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        Coffee coffee = SimpleCoffeeFactory.creatCoffee(type);
        coffee.addsugar();;
        coffee.addMilk();
        return coffee;
    }
}
