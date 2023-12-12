package Inheritance;

public class Fruit {
    private String color;

    private String smell;

    public String getSmell() {
        return this.smell;
    }
}

class Apple extends Fruit{
    private String color;
    private String smell;
    public Apple(String color, String smell) {
        this.color = color;
        this.smell = smell;
    }
    @Override
    public String getSmell() {
        return this.smell;
    }
}

class YoungApple extends Apple{
    private String color;
    private String smell;
    public YoungApple(String color, String smell) {
        super(color, smell);
    }
    @Override
    public String getSmell() {
        return this.smell;
    }
}