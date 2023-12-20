package com.java.observer;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject{

    private List<Observer> wechatUserList=new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        wechatUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        wechatUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer:wechatUserList){
            observer.update(message);
        }
    }
}
