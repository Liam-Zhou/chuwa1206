package pattern.factory.simple_factory;

/**
 * @author xiaorui
 */
public abstract class Coffee {
    public abstract String getName();

    public void addSugar() {
        System.out.println("Add sugar.");
    }

    public void addMilk() {
        System.out.println("Add milk.");
    }
}
