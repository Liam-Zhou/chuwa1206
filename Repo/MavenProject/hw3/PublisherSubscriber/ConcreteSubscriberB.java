package hw3.PublisherSubscriber;

public class ConcreteSubscriberB implements Subscriber {
    @Override
    public void update(String message) {
        System.out.println("ConcreteSubscriberB got message: " + message);
    }
}
