package Repo.MavenProject.NewMavenModule.src.main.java.com.chuwa.learn.deignPattern.factory;

public class CoffeeStore {
    public Coffee orderCoffee(String type) {
//         factory = new SimpleCoffeeFactory();

        // 调用生产咖啡的方法
        Coffee coffee = new SimpleCoffeeFactory().createCoffee(type);

        // 加配料
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
