package PublishSubscriber;

public interface Subject {

    // add subscriber
    void attach(Observer observer);

    // delete subscriber
    void detach(Observer observer);

    void notify(String message);
}
