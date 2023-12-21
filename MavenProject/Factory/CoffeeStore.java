package Factory;

public class CoffeeStore {

    public Coffee orderCoffee(String type) {
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
		//调用生产方法
        Coffee coffee = factory.createCoffee("american");
		//加配料
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
