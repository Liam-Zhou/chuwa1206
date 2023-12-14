package hw3.singleton;

public class Singleton {
    // The private static instance of the hw3.singleton class
    private static Singleton instance;

    // Private constructor to prevent instantiation from other classes
    private Singleton() {}

    // Public method to provide the global access point to the instance
    public static Singleton getInstance() {
        // Lazy initialization
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Example method to demonstrate hw3.singleton usage
    public void doSomething() {
        System.out.println("Doing something...");
    }
}
