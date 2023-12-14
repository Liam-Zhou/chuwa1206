package org.example.Observer;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject{
    private List<Observer> weiXinUserList = new ArrayList<>();

    @Override
    public void attach(Observer obs) {
        weiXinUserList.add(obs);
    }

    @Override
    public void detach(Observer obs) {
        weiXinUserList.remove(obs);
    }

    @Override
    public void notify(String message) {
        for(Observer observer : weiXinUserList){
            observer.update(message);
        }
    }
}
