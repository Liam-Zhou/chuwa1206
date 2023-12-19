package com.chuwa.tutorial.t06_java8.exercise;


public class EmptyCartException extends RuntimeException {

    public EmptyCartException(String message){
        super(message);
    }
}
