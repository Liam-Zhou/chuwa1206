package pattern.factory.simplecoffeefactory;


/**
 * @program: Maven_Project
 * @ClassName CoffeeStore
 * @description:
 * @author: Zhenwei Dai
 * @create: 2023-12-13 19:47
 * @Version 1.0
 **/
public class CoffeeStore {
    public Coffee orderCoffee(String type){
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        Coffee coffee = factory.createCoffee(type);

        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}