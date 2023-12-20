package com.chuwa.SingletonExercise;

public class EagerLoad {
    private static EagerLoad instance = new EagerLoad();

    private EagerLoad(){
    }

    public static EagerLoad getInstance(){
        return instance;
    }
}
