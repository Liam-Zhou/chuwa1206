package pattern.Observer;

public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new SubscriptionSubject();
        subject.attach(new User("A"));
        subject.attach(new User("B"));
        subject.attach(new User("C"));
        subject.notify("Hello");
    }
}
