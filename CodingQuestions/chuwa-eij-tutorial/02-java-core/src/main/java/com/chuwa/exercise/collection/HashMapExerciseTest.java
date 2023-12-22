package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class HashMapExerciseTest {

    /**
     * e.g.
     * Map<String, Integer> map = new HashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * getOrDefault(Object key, V defaultValue)
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
        Map<String, Integer> map = new HashMap<>();

        // put()
        map.put("apple", 10);
        map.put("orange", 20);

        // putIfAbsent()
        map.putIfAbsent("banana", 30);
        map.putIfAbsent("apple", 40);

        // putAll()
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("cherry", 50);
        map.putAll(anotherMap);

        // get()
        System.out.println("apple: " + map.get("apple"));

        // getOrDefault()
        System.out.println("pear: " + map.getOrDefault("pear", 0));

        // containsKey() and containsValue()
        System.out.println("Contains 'apple' key: " + map.containsKey("apple"));
        System.out.println("Contains value 20: " + map.containsValue(20));

        // keySet() and values()
        Set<String> s = map.keySet();
        System.out.println("Keys: " + map.keySet());
        Collection<Integer> v = map.values();
        System.out.println("Values: " + map.values());

        List<Integer> valuesList = new ArrayList<>(v);
        System.out.println(valuesList);

        // isEmpty()
        System.out.println("Is map empty: " + map.isEmpty());
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     * replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
     *
     * remove(Object key)
     * remove(Object key, Object value)
     *
     * compute(Key, BiFunction)
     * computeIfAbsent(Key, Function)
     * computeIfPresent(Key, BiFunction)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 10);
        map.put("orange", 20);
        map.put("banana", 30);

        // replace()
        map.replace("apple", 100);
        map.replace("orange", 20, 200);

        // replaceAll()
        map.replaceAll((key, value) -> value * 2);

        // remove()
        map.remove("banana");

        // remove() with value check
        map.remove("orange", 400);

        // compute()
        map.compute("apple", (key, value) -> (value == null) ? 1 : value + 1);
        map.computeIfAbsent("lemon", key -> 40);
        // computeIfAbsent()
        map.computeIfAbsent("cherry", key -> 42);

        // computeIfPresent()
        map.computeIfPresent("apple", (key, value) -> value + 10);

        System.out.println("Final map: " + map);
    }
}
