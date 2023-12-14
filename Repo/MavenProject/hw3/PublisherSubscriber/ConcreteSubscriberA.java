package hw3.PublisherSubscriber;

public class ConcreteSubscriberA implements Subscriber {
    @Override
    public void update(String message) {
        System.out.println("ConcreteSubscriberA got message: " + message);
    }
}
