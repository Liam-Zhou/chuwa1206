package coding3.singletone;

public class Eager {
    private static final Eager instance = new Eager();
    private Eager(){}
    public static Eager getInstance() {
        return instance;
    }
}
