public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();

        Coffee coffee = store.orderCoffee("Americano");

        System.out.println(coffee.getName());
    }
}
