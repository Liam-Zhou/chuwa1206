package DesignPattern.Publisher_Subscriber;

import java.util.*;

public class SubjectSubscription implements Subject{
    private List<Observer> users = new ArrayList<>();
    @Override
    public void attach(Observer observer) {
        users.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        users.remove(observer);

    }

    @Override
    public void notify(String message) {
        for (Observer user : users) {
            user.update(message);

        }
    }
}
