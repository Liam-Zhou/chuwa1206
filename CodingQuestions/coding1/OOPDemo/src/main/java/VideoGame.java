/**
 * Demonstrate the use of encapsulation, inheritance, and polymorphism.
 */
public class VideoGame {
    private String name;
    private double price;

    public VideoGame(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public int setPrice(double price) {
        if (price < 0) {
            return -1;
        }
        this.price = price;
        return 0;
    }

    public void play() {
        System.out.println("Playing " + this.name);
    }

    public void play(double hours) {
        System.out.println("Playing " + this.name + " for " + hours + " hours");
    }
}
