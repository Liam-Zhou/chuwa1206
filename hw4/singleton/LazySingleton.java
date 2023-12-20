package hw4.singleton;

public class LazySingleton {

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper {
        private static final LazySingleton INSTANCE = new LazySingleton();
    }
}


