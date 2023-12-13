package MavenProject.Publisher_Subscriber;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSunject implements Subject{
    private List<Observer> weixinUserList = new ArrayList<Observer>();
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
