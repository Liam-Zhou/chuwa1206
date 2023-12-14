package pattern.singleton.destroy.reflection;

public class Singleton {
    private Singleton(){}
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
