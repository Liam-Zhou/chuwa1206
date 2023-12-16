package DesignPattern.Factory.Factory;

public class AmericanoFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new Americano();
    }
}
