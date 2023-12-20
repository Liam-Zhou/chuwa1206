package Factory.SimpleFactory;

public class Client {
    public static void main(String[] args) {
        CoffeeStore cs = new CoffeeStore();
        Coffee coffee = cs.orderCoffee("latte");

        System.out.println(coffee.getName());
    }
}
