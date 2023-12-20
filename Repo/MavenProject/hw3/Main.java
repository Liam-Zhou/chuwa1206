import hw3.PublisherSubscriber.ConcreteSubscriberA;
import hw3.PublisherSubscriber.ConcreteSubscriberB;
import hw3.PublisherSubscriber.Publisher;
import hw3.PublisherSubscriber.Subscriber;
import hw3.builder.Car;
import hw3.builder.CarBuilder;
import hw3.factory.Vehicle;
import hw3.factory.VehicleFactory;
import hw3.singleton.Singleton;

public class Main {
    public static void main(String[] args) {
        // Accessing the hw3.singleton instance
        Singleton singletonInstance = Singleton.getInstance();
        singletonInstance.doSomething();

        // hw3.factory pattern
        VehicleFactory vehicleFactory = new VehicleFactory();
        // Get an object of hw3.factory.Car and call its drive method.
        Vehicle vehicle1 = vehicleFactory.getVehicle("CAR");
        vehicle1.drive();
        // Get an object of hw3.factory.Bike and call its drive method.
        Vehicle vehicle2 = vehicleFactory.getVehicle("BIKE");
        vehicle2.drive();

        // hw3.builder pattern
        Car car = new CarBuilder()
                .setMake("Toyota")
                .setModel("Camry")
                .setYear(2020)
                .setColor("Red")
                .setEngineSize(2.5)
                .build();

        System.out.println(car);

        // publisher subscriber
        Publisher publisher = new Publisher();

        Subscriber subscriberA = new ConcreteSubscriberA();
        Subscriber subscriberB = new ConcreteSubscriberB();

        publisher.subscribe(subscriberA);
        publisher.subscribe(subscriberB);

        publisher.notifySubscribers("Hello Subscribers!");

        publisher.unsubscribe(subscriberA);

        publisher.notifySubscribers("Another message!");
    }
}
