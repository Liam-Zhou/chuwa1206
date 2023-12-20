package pattern.factory.factory;




/**
 * @program: Maven_Project
 * @ClassName CoffeeStore
 * @description:
 * @author: Zhenwei Dai
 * @create: 2023-12-13 19:47
 * @Version 1.0
 **/
public class CoffeeStore {
    private  CoffeeFactory factory;
    public void setFactory(CoffeeFactory factory){
        this.factory = factory;
    }
    public Coffee orderCoffee(){
        Coffee coffee = factory.createCoffee();

        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}