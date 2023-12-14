package MavenProject_designPattern.singletone.egaer.staticField;

public class Client {
    public static void main(String[] args) {
        Singletone instance1 = Singletone.getSingletone();
        Singletone instance2 = Singletone.getSingletone();

        //判断是否同一个对象
        System.out.println(instance1 == instance2);
    }
}
