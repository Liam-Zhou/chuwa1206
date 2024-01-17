package pattern.Observer;

import java.util.*;

public class SubscriptionSubject implements Subject{
    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
        System.out.println("Attached an observer");
    }

    public void detach(Observer observer) {
        observers.remove(observer);
        System.out.println("Detached an observer");
    }

    public void notify(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
