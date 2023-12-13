package pattern.factory.before;

public class CoffeeStore {
    public Coffee orderCoffee(String type) {
        Coffee coffee = null;
        if ("American".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("Latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("Wrong Coffee");
        }

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
