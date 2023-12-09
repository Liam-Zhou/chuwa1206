package Polymorphism;

public class Fruit {
    private String smell = "fruitiful";
    public String getSmell() {
        return smell;
    }
}

class Apple extends Fruit{

    private String smell;

    public Apple(String smell) {
        this.smell = smell;
    }

    @Override
    public String getSmell() {
        return this.smell;
    }
}

class Durian extends Fruit {
    private String smell;

    public Durian(String smell) {
        this.smell = smell;
    }

    @Override
    public String getSmell() {
        return this.smell;
    }
}
