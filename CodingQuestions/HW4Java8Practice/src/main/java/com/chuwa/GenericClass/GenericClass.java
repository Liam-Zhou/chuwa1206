package com.chuwa.GenericClass;

public class GenericClass<T> {
    T object;

    public GenericClass(T object){
        this.object = object;
    }

    public T getObject(){
        return this.object;
    }
}
