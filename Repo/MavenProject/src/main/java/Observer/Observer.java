package Observer;

public interface Observer {
//    void attach(Subject subject);
//
//    void detach(Subject subject);

    void notify(String message);

    void update(String message);
}
