package com.chuwa.learn.javacore.Observer;

public interface Subject {
        void attach(Observer obs);

        void detach(Observer obs);

        void notify(String message);
}
