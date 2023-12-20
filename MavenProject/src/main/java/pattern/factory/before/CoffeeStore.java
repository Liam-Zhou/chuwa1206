package pattern.factory.before;

public class CoffeeStore {

    public Coffee orderCoffee(String type) {

        Coffee coffee = null;
        if("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("Sorry, we dont have it");
        }

        coffee.addMilke();
        coffee.addSuger();
        return coffee;
    }
}
