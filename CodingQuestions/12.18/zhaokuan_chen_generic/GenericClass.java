package com.chuwa.tutorial.t01_basic.zhaokuan_chen_generic;

public class GenericClass <T> {
    T obj;

    public GenericClass(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}
