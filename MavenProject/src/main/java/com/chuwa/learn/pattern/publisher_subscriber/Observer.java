package com.chuwa.learn.pattern.publisher_subscriber;

public interface Observer {
    void notify(String message);

    void update(String message);
}