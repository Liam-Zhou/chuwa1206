package pattern.factory.factory;

/**
 * @program: Maven_Project
 * @ClassName LatteFactory
 * @description:
 * @author: Zhenwei Dai
 * @create: 2023-12-13 22:40
 * @Version 1.0
 **/
public class LatteFactory implements CoffeeFactory{

    @Override
    public Coffee createCoffee() {
        return new Latte();
    }
}