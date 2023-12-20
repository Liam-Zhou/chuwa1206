package MavenProject_designPattern.publisher_Subscriber;



public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notify(String message);
}
