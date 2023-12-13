public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        //创建工厂对象
        CoffeeFactory factory = new AmericanoFactory();
        store.setFactory(factory);

        //点咖啡
        Coffee coffee = store.orderCoffee();

        System.out.println(coffee.getName());
    }
}
