import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void update(String message);
}

// 发布者类
class NewsPublisher {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publishNews(String news) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(news);
        }
    }
}

class UserSubscriber implements Subscriber {
    private final String name;

    public UserSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received news: " + message);
    }
}

public class Publisher_Subscriber {
}
