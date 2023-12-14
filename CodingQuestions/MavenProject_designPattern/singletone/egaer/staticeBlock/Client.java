package MavenProject_designPattern.singletone.egaer.staticeBlock;

public class Client {
    public static void main(String[] args) {
        Singletone instance1 = Singletone.getInstance();
        Singletone instance2 = Singletone.getInstance();
        System.out.println(instance1 == instance2);
    }
}
