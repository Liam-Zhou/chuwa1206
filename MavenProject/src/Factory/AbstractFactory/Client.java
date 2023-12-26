package Factory.AbstractFactory;

public class Client {
    public static void main(String[] args) {
        DessertFactory factory = new ItalyDessertFactory();

        Coffee coffee = factory.createCoffee();
        Dessert dessert = factory.createDessert();

        System.out.println(coffee.getName());
        dessert.show();
    }
}
