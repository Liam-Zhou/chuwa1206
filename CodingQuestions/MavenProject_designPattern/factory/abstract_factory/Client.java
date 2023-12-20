package MavenProject_designPattern.factory.abstract_factory;

public class Client {
    public static void main(String[] args) {
        //创建的是意大利风味甜品工厂对象
        ItalyDessertFactory italyDessertFactory = new ItalyDessertFactory();
        AmericanDessertFactory americanDessertFactoryfactory = new AmericanDessertFactory();
        //获取拿铁咖啡和提拉米苏甜品
        Coffee coffee = italyDessertFactory.createCoffee();
        Dessert dessert = italyDessertFactory.createDessert();

        System.out.println(coffee.getName());
        dessert.show();

        Coffee coffee1 = americanDessertFactoryfactory.createCoffee();
        Dessert dessert1 = americanDessertFactoryfactory.createDessert();

        System.out.println(coffee1.getName());
        dessert1.show();
    }
}
