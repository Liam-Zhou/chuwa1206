package com.chuwa.exercise.collection;
import org.junit.Test;
import java.time.DayOfWeek;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Yuanting Sun
 * @date 12/12/2023
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
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        System.out.println("Map Size" + map.size());

        map.putIfAbsent("Hello", 100);
        System.out.println("Map now Size" + map.size());

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("D", 4);
        map1.put("E", 5);

        map.putAll(map1);
        System.out.println("Combined Map" + map);
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
        map.put(DayOfWeek.TUESDAY, 1);
        map.put(DayOfWeek.SATURDAY, 2);
        System.out.println("Map" + map);

        Map<DayOfWeek, Integer> map1 = new IdentityHashMap<>();
        map1.putAll(map);
        System.out.println("New Map" + map1);
    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.SATURDAY, 6);
        enumMap.put(DayOfWeek.MONDAY, 1);
        System.out.println("Map" + enumMap.size());

        enumMap.putIfAbsent(DayOfWeek.SUNDAY, 7);
        System.out.println("Now map" + enumMap);
    }
}
