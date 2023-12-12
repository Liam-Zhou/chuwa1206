package Factory;

public class CoffeeShop {
    public Coffee orderCoffee(String type) {
        Coffee coffee = null;
        if ("American".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("Latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("Coffee not found");
        }
        coffee.addSugar();
        coffee.addMilk();
        return coffee;
    }
}
