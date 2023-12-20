package MavenProject_designPattern.factory.simple_factory;

public abstract class Coffee {

    public abstract String getName();


    public void addsugar() {
        System.out.println("add sugar");
    }

    public void addMilk() {
        System.out.println("add milk");
    }
}
