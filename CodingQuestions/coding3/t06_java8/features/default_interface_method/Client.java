package coding3.t06_java8.features.default_interface_method;

public class Client {
    public static void main(String[] args) {
        DIMImpl dim = new DIMImpl();
        System.out.println("override add()" + dim.add(1,2));
        System.out.println("default substract()" + dim.substract(1,2));
        System.out.println("static blogName()" + DIML.blogName());
    }
}
