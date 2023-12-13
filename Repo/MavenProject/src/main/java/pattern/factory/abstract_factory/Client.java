package pattern.factory.abstract_factory;

public class Client {
    public static void main(String[] args) {
        DessertFactory dessertFactory = new AmericanDessertFactory();
        Coffee coffee = dessertFactory.createCoffee();
        Dessert dessert = dessertFactory.createDessert();
        System.out.println(coffee.getName());
        dessert.show();
    }
}
