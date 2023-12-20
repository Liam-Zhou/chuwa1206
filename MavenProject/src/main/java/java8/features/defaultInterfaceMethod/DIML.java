package java8.features.defaultInterfaceMethod;

public interface DIML {
    static final String BLOG = "is Chuwa a";

    // abstract method
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
