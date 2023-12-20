package MavenProject.Singleton;

public class SingletonEagerLoadStaticBlock {
    private SingletonEagerLoadStaticBlock() {}

    private static SingletonEagerLoadStaticBlock instance;

    static {
        instance = new SingletonEagerLoadStaticBlock();
    }

    public static SingletonEagerLoadStaticBlock getInstance() {
        return instance;
    }

}
