import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject{
    //定义集合，存储多个观察者对象
    private List<Observer> wechatList = new ArrayList<>();
    @Override
    public void attach(Observer observer) {
        wechatList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        wechatList.remove(observer);
    }

    @Override
    public void notify(String message) {
        //遍历集合
        for (Observer observer : wechatList) {
            observer.update(message);
        }
    }
}
