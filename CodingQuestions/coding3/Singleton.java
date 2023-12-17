//Lazy
public class LazyLoadedSingleton {
    private static LazyLoadedSingleton _instance;
    private LazyLoadedSingleton(){};
    public static synchronized LazyLoadedSingleton getInstance() {
        if(_instance == null) {
            _instance = new LazyLoadedSingleton();
        }
        return _instance;
    }
}

//Eager

public class EagerLoadedSingleton {
    private static EagerLoadedSingleton _instance = new EagerLoadedSingleton();
    private EagerLoadedSingleton(){};
    public static synchronized EagerLoadedSingleton getInstance() {return _instance;}
}