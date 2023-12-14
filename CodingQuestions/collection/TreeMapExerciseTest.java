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
        // Creating a TreeMap with String keys and Integer values
        TreeMap<String, Integer> map = new TreeMap<>();

        // Inserting elements
        map.put("apple", 2);
        map.putIfAbsent("banana", 3);

        // Adding elements from another map
        Map<String, Integer> anotherMap = Map.of("orange", 4, "grape", 5);
        map.putAll(anotherMap);

        // Retrieving elements
        int appleValue = map.get("apple");
        System.out.println("Value for 'apple': " + appleValue);

        // Retrieving the first and last keys
        String firstKey = map.firstKey();
        String lastKey = map.lastKey();
        System.out.println("First Key: " + firstKey);
        System.out.println("Last Key: " + lastKey);

        // Checking if a key or value exists
        boolean containsKey = map.containsKey("banana");
        boolean containsValue = map.containsValue(5);
        System.out.println("Contains 'banana': " + containsKey);
        System.out.println("Contains value 5: " + containsValue);

        // Retrieving key set and values
        System.out.println("Key Set: " + map.keySet());
        System.out.println("Values: " + map.values());

        // Checking if the map is empty
        boolean isEmpty = map.isEmpty();
        System.out.println("Is the map empty? " + isEmpty);
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {

    }
}
