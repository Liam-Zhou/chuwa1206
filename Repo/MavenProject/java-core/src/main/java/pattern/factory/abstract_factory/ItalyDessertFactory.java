package pattern.factory.abstract_factory;

public class ItalyDessertFactory implements DessertFactory{
    @Override
    public Dessert createDessert() {
        return new Trumisu();
    }

    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
