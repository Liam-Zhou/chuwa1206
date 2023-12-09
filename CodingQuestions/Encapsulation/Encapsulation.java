package Encapsulation;

public class Encapsulation {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        apple1.setColor("green");
        apple1.setWeight(2.1);
        System.out.println(apple1.info());
    }
}

class Apple {

    private String color;

    private double weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String info() {
        return "color: " + this.color + ", " + "weight: " + this.weight;
    }
}