package pattern.factory.factory_method;

public class Client {
    public static void main(String[] args) {//创建咖啡店对象
        CoffeeStore store = new CoffeeStore();

        //CoffeeFactory factory = new AmericanCoffeeFactory();
        CoffeeFactory factory = new LatteCoffeeFactory();
        store.setFactory(factory);


        Coffee coffee = store.orderCoffee();

        System.out.println(coffee.getName());
    }
}
