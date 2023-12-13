public class AmericanDessertFactory implements DessertFactory{
    @Override
    public Dessert creteDessert() {
        return new MatchaMousse();
    }

    @Override
    public Coffee createCoffee() {
        return new Americano();
    }
}
