package MavenProject.Singleton;

public class SingletonEagerLoad {
    private SingletonEagerLoad() {}

    private static SingletonEagerLoad instance = new SingletonEagerLoad();

    public static SingletonEagerLoad getInstance() {
        return instance;
    }
}
