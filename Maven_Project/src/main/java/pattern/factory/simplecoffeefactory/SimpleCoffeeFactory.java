package pattern.factory.simplecoffeefactory;

/**
 * @program: Maven_Project
 * @ClassName SimpleCoffeeFactory
 * @description:
 * @author: Zhenwei Dai
 * @create: 2023-12-13 19:48
 * @Version 1.0
 **/
public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type){
        Coffee coffee = null;
        if("american".equals(type)){
            coffee = new Americano();
        }else if ("latte".equals(type)){
            coffee = new Latte();
        }else {
            throw new RuntimeException("Sorry, the coffee you ordered doesn't exist");
        }
        return coffee;
    }

}