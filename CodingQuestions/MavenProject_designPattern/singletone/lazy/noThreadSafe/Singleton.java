package MavenProject_designPattern.singletone.lazy.noThreadSafe;

public class Singleton {
    public Singleton() {
    }
    private static Singleton instace;
    public static Singleton getInstance() {
        //这里有可能线程不安全
        if (instace == null) instace = new Singleton();
        return instace;
    }
}
