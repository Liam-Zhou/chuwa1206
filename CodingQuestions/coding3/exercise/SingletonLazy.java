public class SingletonLazy {
    private static SingletonLazy lazy;
    private SingletonLazy(){};
    public static synchronized SingletonLazy getInstance() {
        if(lazy == null) {
            lazy = new SingletonLazy();
        }
        return lazy;
    }
}
