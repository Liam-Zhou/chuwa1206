package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class LinkedHashMapExerciseTest {
    /**
     * e.g.
     * HashMap<String, Integer> map = new LinkedHashMap<>();
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
        Map<String, Integer> map = new LinkedHashMap<>();


        map.put("key1", 10);
        assertEquals(Integer.valueOf(10), map.get("key1"));


        map.putIfAbsent("key2", 20);
        assertEquals(Integer.valueOf(20), map.get("key2"));


        assertEquals(Integer.valueOf(20), map.getOrDefault("key2", 0));
        assertEquals(Integer.valueOf(0), map.getOrDefault("key3", 0));


        assertTrue(map.containsKey("key1"));
        assertFalse(map.containsKey("key3"));
        assertTrue(map.containsValue(10));
        assertFalse(map.containsValue(30));


        assertTrue(map.keySet().contains("key1"));
        assertTrue(map.values().contains(10));

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
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("key1", 10);
        map.put("key2", 20);


        map.replace("key1", 30);
        assertEquals(Integer.valueOf(30), map.get("key1"));

        map.replace("key2", 20, 40);
        assertEquals(Integer.valueOf(40), map.get("key2"));


        BiFunction<String, Integer, Integer> function = (key, oldValue) -> oldValue + 10;
        map.replaceAll(function);
        assertEquals(Integer.valueOf(50), map.get("key2"));


        map.remove("key1");
        assertFalse(map.containsKey("key1"));

        map.put("key3", 30);
        map.remove("key3", 30);
        assertFalse(map.containsKey("key3"));

        map.compute("key2", (key, value) -> (value == null) ? 1 : value + 5);
        assertEquals(Integer.valueOf(55), map.get("key2"));

        Function<String, Integer> computeFunction = k -> 60;
        map.computeIfAbsent("key4", computeFunction);
        assertEquals(Integer.valueOf(60), map.get("key4"));

        BiFunction<String, Integer, Integer> computeIfPresentFunction = (key, value) -> value + 5;
        map.computeIfPresent("key2", computeIfPresentFunction);
        assertEquals(Integer.valueOf(60), map.get("key2"));
    }
}
