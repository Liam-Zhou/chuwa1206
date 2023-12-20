package MavenProject_designPattern.factory.statice_factory;


/**

 */
public class CoffeeStore {

    public Coffee orderCoffee(String type) {

//        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
//        //调用生产咖啡的方法
//        Coffee coffee = factory.createCoffee(type);
        Coffee coffee = SimpleCoffeeFactory.createCoffee(type);

        //加配料
        coffee.addMilk();
        coffee.addsugar();

        return coffee;
    }
}
