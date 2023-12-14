package pattern.publish_subscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Maven_Project
 * @ClassName SubscriptionSubject
 * @description:concrete subject
 * @author: Zhenwei Dai
 * @create: 2023-12-13 23:29
 * @Version 1.0
 **/
public class SubscriptionSubject implements Subject{

    List<Observer> weixinUserList = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        weixinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weixinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weixinUserList) {
            observer.update(message);
        }
    }
}