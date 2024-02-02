package java8.features.default_interface_method;

public class Client {
    public static void main(String[] args) {
        DIMLImpl dim = new DIMLImpl();
        System.out.println("Override method:" + dim.add(1, 2));
        System.out.println("Default method:" + dim.substract(1, 2));
        System.out.println("Static method:" + DIML.blogName());
    }
}
