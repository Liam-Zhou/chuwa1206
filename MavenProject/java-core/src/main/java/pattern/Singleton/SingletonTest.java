package pattern.Singleton;

public class SingletonTest {
    public static void main(String[] args) {
        SingletonEager1 s1 = SingletonEager1.getInstance();
        SingletonEager1 s2 = SingletonEager1.getInstance();

        System.out.println("s1 == s2: " + (s1 == s2));
    }
}
