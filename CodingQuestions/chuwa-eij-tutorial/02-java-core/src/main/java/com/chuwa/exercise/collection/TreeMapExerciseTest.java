package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class TreeMapExerciseTest {

    /**
     * e.g.
     * TreeMap<String, Integer> map = new TreeMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * firstKey()
     * lastKey()
     *
     * containsKey(Object key)
     * containsValue(Object value)
     *
     * keySet()
     * values()
     * isEmpty()
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        TreeMap<String, Integer> map = new TreeMap<>();

        // Inserting
        map.put("apple", 10);
        map.put("banana", 20);
        map.putIfAbsent("cherry", 30);
        map.putIfAbsent("apple", 40);

        Map<String, Integer> anotherMap = new TreeMap<>();
        anotherMap.put("date", 50);
        map.putAll(anotherMap);

        // Retrieving
        System.out.println("apple: " + map.get("apple"));
        System.out.println("First key: " + map.firstKey());
        System.out.println("Last key: " + map.lastKey());

        System.out.println("Contains 'apple' key: " + map.containsKey("apple"));
        System.out.println("Contains value 20: " + map.containsValue(20));

        System.out.println("Keys: " + map.keySet());
        System.out.println("Values: " + map.values());

        System.out.println("Is map empty: " + map.isEmpty());
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("cherry", 30);

        // Replacing
        map.replace("apple", 100);
        map.replace("banana", 20, 200);

        // Removing
        map.remove("cherry");

        System.out.println("Final map: " + map);
    }
}
