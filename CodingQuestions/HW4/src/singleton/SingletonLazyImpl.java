package singleton;

public class SingletonLazyImpl {
    public static void main(String[] args) {
        Singletonlazy sl1 = Singletonlazy.getSingletonInstance();
        Singletonlazy sl2 = Singletonlazy.getSingletonInstance();
        System.out.println(sl1 == sl2);
    }

}
class Singletonlazy{
    private static Singletonlazy instance;

    private Singletonlazy() {}

    public static Singletonlazy getSingletonInstance() {
        if (instance == null) {
            instance = new Singletonlazy();
        }
        return instance;
    }
}

