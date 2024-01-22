package observer;

public interface Subject {

    // add a subscriber
    void attach(Observer observer);

    // remove a subscriber
    void detach(Observer observer);

    // notify
    void notify(String message);
}
