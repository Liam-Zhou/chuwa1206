public class Client {
    public static void main(String[] args) {
        ItalianDessertFactory factory = new ItalianDessertFactory();

        Dessert dessert = factory.creteDessert();
        Coffee coffee = factory.createCoffee();

        System.out.println(coffee.getName());
        dessert.show();
    }
}
