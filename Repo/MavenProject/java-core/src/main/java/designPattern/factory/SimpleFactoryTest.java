package designPattern.factory;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("latte");
        System.out.println(coffee.getName());

        coffee = store.orderCoffee("american");
        coffee.addMilk();

        coffee = store.orderCoffee("latte");
        System.out.println(coffee.getName());
    }

}
