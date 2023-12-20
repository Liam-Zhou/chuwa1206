package com.chuwa.exercise.collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.IdentityHashMap;
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
        // Creating a ConcurrentHashMap with String keys and Integer values
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Inserting elements
        map.put("apple", 2);
        map.putIfAbsent("banana", 3);

        // Adding elements from another map
        Map<String, Integer> anotherMap = Map.of("orange", 4, "grape", 5);
        map.putAll(anotherMap);
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
        Map<DayOfWeek, Integer> map = new IdentityHashMap<>();

        // Inserting elements
        map.put(DayOfWeek.MONDAY, 1);
        map.putIfAbsent(DayOfWeek.TUESDAY, 2);

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
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);

        // Inserting elements
        enumMap.put(DayOfWeek.MONDAY, 1);
        enumMap.putIfAbsent(DayOfWeek.TUESDAY, 2);
    }
}
