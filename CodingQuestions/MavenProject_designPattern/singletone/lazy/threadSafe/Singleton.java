package MavenProject_designPattern.singletone.lazy.threadSafe;

public class Singleton {
    public Singleton() {
    }
    private static Singleton instace;
    public static synchronized Singleton getInstance() {
        //这里有可能线程不安全, 所以锁了getInstance()
        if (instace == null) instace = new Singleton();
        return instace;
    }
}
