package hw4.singleton;

public class EagerLoad {
    private EagerLoad() {}
    private static EagerLoad instance = new EagerLoad();

    public static EagerLoad getInstance() {
        return instance;
    }
}
