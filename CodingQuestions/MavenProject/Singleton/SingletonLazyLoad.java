package MavenProject.Singleton;

public class SingletonLazyLoad {
    private SingletonLazyLoad() {

    }

    private static class SingletonHolder {
        private static final SingletonLazyLoad INSTANCE = new SingletonLazyLoad();
    }

    public static SingletonLazyLoad getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
