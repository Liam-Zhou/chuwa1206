package hw4.features.default_interface_method;

/**
 * @program: CodingQuestions
 * @ClassName Client
 * @description:
 * @author: Zhenwei Dai
 **/
public class Client {
    public static void main(String[] args) {
        DIMImpl dim = new DIMImpl();
        System.out.println("Override method: " + dim.add(1, 2));
        System.out.println("default method: " + dim.substract(1, 2));
        System.out.println("static method: " + DIML.blogName());
    }
}