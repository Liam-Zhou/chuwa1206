package org.patterndesign.factory.before;

public class CoffeeStore {

    public Coffee orderCoffee(String type) {
        Coffee coffee = null;
        if("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("对不起，您所点的咖啡没有");
        }
        coffee.addMilk();
        coffee.addsugar();

        return coffee;
    }
}
