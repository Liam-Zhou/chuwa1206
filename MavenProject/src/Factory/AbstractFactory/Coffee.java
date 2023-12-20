package Factory.AbstractFactory;

public abstract class Coffee {

    public abstract String getName();

    // add sugar
    public void addsugar() {
        System.out.println("add sugar");
    }

    // add milk
    public void addmilk() {
        System.out.println("add milk");
    }
}
