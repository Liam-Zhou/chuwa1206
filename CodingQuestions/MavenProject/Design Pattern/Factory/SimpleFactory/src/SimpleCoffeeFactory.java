public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type) {
        //声明Coffee类型的变量
        Coffee coffee = null;

        if ("Americano".equals(type)) {
            coffee = new Americano();
        } else if ("Latte".equals(type)) {
            coffee = new Latte();
        } else {
            throw new RuntimeException("No such Coffee");
        }

        return coffee;
    }
}
