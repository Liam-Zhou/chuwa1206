package pattern.factory.factory;

/**
 * @program: Maven_Project
 * @ClassName AA
 * @description:
 * @author: Zhenwei Dai
 * @create: 2023-12-13 22:33
 * @Version 1.0
 **/
public class AmericanoFactory implements CoffeeFactory {

    @Override
    public Coffee createCoffee() {
        return new Americano();
    }
}