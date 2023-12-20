package tutorial.t06_java8.features.default_interface_method;

public interface DIML {
    static final String BLOG = "Chuwa example";

    // abstract method
    int add(int a, int b);

    // default method
    default int subtract(int a, int b) {
        return a - b;
    }

    static String blogName() {
        return BLOG;
    }
}
