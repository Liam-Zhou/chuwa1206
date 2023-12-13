package MavenProject.Singleton;

public class SingletonDoubleCheck {
    private SingletonDoubleCheck() {}

    private static SingletonDoubleCheck instance;

    public static SingletonDoubleCheck getInstance() {

        if (instance == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (instance == null) {
                    instance = new SingletonDoubleCheck();
                }
            }
        }

        return instance;
    }

}
