package pattern.factory.simple_factory;

public class SimpleCoffeeFactory {
    public Coffee creatCoffee(String type){
        Coffee coffee = null;
        if("american".equals(type)){
            coffee =new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        }else{
            throw new RuntimeException("没有咖啡");
        }

        coffee.addMilk();
        coffee.addsugar();
        return coffee;
    }
}
