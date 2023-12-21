package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class AdditionalMapExerciseTest {

    /**
     * e.g.
     * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     */
    @Test
    public void learn_ConcurrentHashMap() {
        System.out.println("Test ConcurrentHashMap\n");
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A",1);
        map.put("B",2);
        ConcurrentHashMap<String, Integer> map2 = new ConcurrentHashMap<>();
        map2.putAll(map);
        for(Map.Entry<String,Integer> entry: map2.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {

    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {

    }
}
