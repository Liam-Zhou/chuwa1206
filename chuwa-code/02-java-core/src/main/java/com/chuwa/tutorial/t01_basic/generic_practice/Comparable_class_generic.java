package com.chuwa.tutorial.t01_basic.generic_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Comparable_class_generic {
    public static void main(String[] args){
        List<CPair<Integer, Integer>> lst=new ArrayList<>();
        lst.add(new CPair<Integer,Integer>(5,2));
        lst.add(new CPair<>(4,5));
        lst.add(new CPair<>(5,10));
        lst.add(new CPair<>(1,11));
        lst.sort(null);

        lst.forEach(pair->System.out.println(pair.getKey()+","+pair.getValue()));

        CPair<Integer,Integer> maxpair=CPairFeatures.MaxPair(lst);
        System.out.println(maxpair.getKey()+","+maxpair.getValue());
    }
}

class CPair<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<CPair<K,V>>{
    private K key;
    private V value;

    public CPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
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


    @Override
    public int compareTo(CPair<K,V> other){
        if(this.key!=other.getKey())
            return this.key.compareTo(other.key);
        else
            return this.value.compareTo(other.value);
    }

}

class CPairFeatures {
    public static <K extends Comparable<K>, V extends Comparable<V>> CPair<K, V> MaxPair(List<CPair<K,V>> lst){
        CPair<K,V> maxpair = lst.get(0);
        for(CPair<K,V> pair:lst){
            if(pair.compareTo(maxpair) > 0)
                maxpair = pair;
        }
        return maxpair;

    }
}