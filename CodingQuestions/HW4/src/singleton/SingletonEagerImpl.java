package singleton;

public class SingletonEagerImpl {
    public static void main(String[] args) {
        Singletoneager sl1 = Singletoneager.getSingletonInstance();
        Singletoneager sl2 = Singletoneager.getSingletonInstance();
        System.out.println(sl1 == sl2);
    }

}
class Singletoneager{
    private static Singletoneager instance = new Singletoneager();

    private Singletoneager() {}

    public static Singletoneager getSingletonInstance() {
        return instance;
    }
}
