package com.chuwa.SingletonExercise;

public class LazyLoad {
    private LazyLoad(){

    }

    private static class holder{
        private static final LazyLoad instance = new LazyLoad();
    }

    public static LazyLoad getInstance(){
        return holder.instance;
    }
}
