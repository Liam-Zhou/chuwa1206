package pattern.factory.before;

public class CoffeeStore {
    public  Coffee orderCoffee(String type){

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
