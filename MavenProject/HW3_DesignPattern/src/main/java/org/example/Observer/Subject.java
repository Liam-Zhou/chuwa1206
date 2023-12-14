package org.example.Observer;

public interface Subject {
    void attach(Observer obs);

    void detach(Observer obs);

    void notify(String message);
}
