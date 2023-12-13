/**
 * @Description: 生产Americano的工厂
 */
public class AmericanoFactory implements CoffeeFactory{
    public Coffee createCoffee() {
        return new Americano();
    }
}
