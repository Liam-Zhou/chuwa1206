package DesignPattern.Singleton.LazyLoadSingleton3;

public class Singleton {
    private Singleton(){};

    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }


    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
