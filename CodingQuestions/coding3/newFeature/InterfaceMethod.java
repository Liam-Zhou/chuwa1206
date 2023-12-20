public interface DIML {
    static final String BLOG = "blahblahblah";

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

public class DIMImpl implements DIML {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}


public class Client {
    public static void main(String[] args) {
        DIMImpl dim = new DIMImpl();
        System.out.println("Override method: " + dim.add(1, 2));
        System.out.println("default method: " + dim.substract(1, 2));
        System.out.println("static method: " + DIML.blogName());
    }
}