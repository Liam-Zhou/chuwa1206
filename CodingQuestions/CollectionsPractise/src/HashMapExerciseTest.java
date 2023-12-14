//package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

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
        map.put("a", 1);
        map.putIfAbsent("b", 2);
        map.putAll(Map.of("c", 3, "d", 4));
        assertEquals(4, map.size());
        assertEquals(7, map.getOrDefault("e", 7).intValue());
        assertEquals(true, map.containsKey("a"));
        assertEquals(true, map.containsValue(4));
        assertEquals(false, map.isEmpty());

        for (String key : map.keySet()) {
            System.out.println(key);
        }

        for (Integer value : map.values()) {
            System.out.println(value);
        }


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
        map.put("a", 1);
        map.put("b", 2);

        map.replace("a", 1, 3);
        assertEquals(3, map.get("a").intValue());

        map.replace("b", 4);
        assertEquals(4, map.get("b").intValue());

        map.replaceAll((k, v) -> v * 2);
        assertEquals(6, map.get("a").intValue());
        assertEquals(8, map.get("b").intValue());

        map.remove("a");
        assertEquals(1, map.size());

        map.remove("b", 8);
        assertEquals(1, map.size());

        map.remove("b", 4);
        assertEquals(0, map.size());

        map.put("a", 1);
        map.compute("a", (k, v) -> v * 2);
        assertEquals(2, map.get("a").intValue());

        map.computeIfAbsent("b", k -> 3);
        assertEquals(3, map.get("b").intValue());

        map.computeIfPresent("a", (k, v) -> v * 2);
        assertEquals(4, map.get("a").intValue());
    }
}
