public class ItalianDessertFactory implements DessertFactory{
    @Override
    public Dessert creteDessert() {
        return new Tiramisu();
    }

    @Override
    public Coffee createCoffee() {
        return new Latte();
    }
}
