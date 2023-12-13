/**
 * @Description: 生产Latte的工厂
 */
public class LatteFactory implements CoffeeFactory{
    public Coffee createCoffee() {
        return new Latte();
    }
}
