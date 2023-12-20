import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        weatherStation.attach(new WeatherSubscriber("张三"));
        weatherStation.attach(new WeatherSubscriber("李四"));
        weatherStation.attach(new WeatherSubscriber("王五"));

        weatherStation.notifySubscribers("今天温度28度");
    }
}

public interface Observer {
    void update(String message);
}

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifySubscribers(String message);
}

public class WeatherStation implements Subject {
    private List<Observer> subscribers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifySubscribers(String message) {
        for (Observer observer : subscribers) {
            observer.update(message);
        }
    }
}


public class WeatherSubscriber implements Observer {
    private String name;

    public WeatherSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " 收到天气更新: " + message);
    }
}
