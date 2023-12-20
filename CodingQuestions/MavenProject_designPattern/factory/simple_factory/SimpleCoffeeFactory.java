package MavenProject_designPattern.factory.simple_factory;

/**
简单工厂模式
 */
public class SimpleCoffeeFactory {

    public Coffee createCoffee(String type) {
        //根据不同类型创建不同的coffee子类对象
        Coffee coffee = null;
        if("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("not offered");
        }

        return coffee;
    }
}
