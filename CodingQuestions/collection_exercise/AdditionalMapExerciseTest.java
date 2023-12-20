package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;
import java.util.concurrent.*;

import static org.junit.Assert.*;

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

    /**
     * Thread-safe hashmap
     * */
    @Test
    public void learn_ConcurrentHashMap() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        map.putIfAbsent("A",2);
        map.putAll(Map.of("B",2, "C", 3));
        assertEquals(Map.of("A", 1, "B",2, "C", 3), map);
    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    /**
     * keys are considered to be equal if k1 == k2
     * */
    private enum DayOfWeek {
        FRIDAY, MONDAY, SATURDAY, SUNDAY,
        THURSDAY, TUESDAY, WEDNESDAY

    }

    @Test
    public void learn_IdentityHashMap() {
        Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
        map.put(DayOfWeek.MONDAY,1);
        assertNotNull(map.put(DayOfWeek.MONDAY,2));
    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */

    /**
     * The EnumMap class in Java is a specialized map implementation that is designed specifically for use with enum keys.
     * An EnumMap is a compact, efficient, and fast alternative to using a HashMap with enum keys.
     * */
    @Test
    public void learn_EnumMap() {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.MONDAY,1);
        enumMap.put(DayOfWeek.TUESDAY,2);
        enumMap.putIfAbsent(DayOfWeek.WEDNESDAY, 3);
        assertNotNull(enumMap.get(DayOfWeek.TUESDAY));


    }
}
