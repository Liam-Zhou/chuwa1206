package java8.features.default_interface_method;


public interface DIML {
    static final String BLOG = "This is hw4.";

    // abstract class
    int add(int a, int b);

    // default method
    default int substract(int a, int b) {
        return a - b;
    }

    // static method
    static String blogName() {
        return BLOG;
    }
}
