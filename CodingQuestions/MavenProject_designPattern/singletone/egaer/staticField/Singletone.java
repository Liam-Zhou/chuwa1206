package MavenProject_designPattern.singletone.egaer.staticField;

public class Singletone {
    //private constructor
    private Singletone() {}
    //creat singleton
    private static Singletone instance = new Singletone();

    //provide access to others
    public static Singletone getSingletone() {
        return instance;
    }
}
