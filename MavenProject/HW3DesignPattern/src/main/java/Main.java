import Builder.Director;
import Builder.MobikeBuilder;
import Builder.Bike;
import Factory.Coffee;
import Factory.CoffeeStore;
import PublishSubscriber.SubscriptionSubject;
import PublishSubscriber.userObserver;
import Singleton.SingletonEager;
import Singleton.SingletonLazy;

public class Main {
    public static void main(String[] args) {
        // Singleton
        SingletonEager eagerInstance = SingletonEager.getInstance();
        SingletonLazy lazyInstance = SingletonLazy.getInstance();

        // Factory
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("latte");
        System.out.println(coffee.getName());

        // Builder
        Director director = new Director(new MobikeBuilder());
        Bike bike = director.construct();
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());

        // Publish Subscriber
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.attach(new userObserver("user-1"));
        subject.attach(new userObserver("user-2"));
        subject.attach(new userObserver("user-3"));

        subject.notify("publisher has updated");
    }
}
