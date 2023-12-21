package com.chuwa.tutorial.t01_basic.generic_practice;

import java.util.ArrayList;
import java.util.List;

public class simple_class_generic {
    public static void main(String[] args){
        List<Pair>lst=new ArrayList<>();        // raw use, not safe
        lst.add(new Pair<Integer,Character>(1,'a'));
        lst.add(new Pair<Double, String>(2.0,"also"));
        lst.add(new Pair<Float, Float>(2f,1.5f));
        lst.forEach( pair-> System.out.println(pair.getKey()+"="+pair.getValue()));
    }
}

class Pair <K,V> {
    private K key;
    private V value;

    public Pair(K key, V value){
        this.key=key;
        this.value=value;
    }
    public K getKey(){
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}