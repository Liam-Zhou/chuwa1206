package pattern.factory.abstract_factory;

public abstract class Coffee {

    public abstract String getName();

    public void addSugar() {
        System.out.println("Add sugar");
    }

    public void addMilk() {
        System.out.println("Add Milk");
    }
}
