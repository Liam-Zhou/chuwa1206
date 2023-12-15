package com.chuwa.learn.observer;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject{
    private List<Observer> userlist = new ArrayList<>();
    @Override
    public void attach(Observer observer) {
        userlist.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        userlist.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer ob : userlist){
            ob.update(message);
        }
    }
}
