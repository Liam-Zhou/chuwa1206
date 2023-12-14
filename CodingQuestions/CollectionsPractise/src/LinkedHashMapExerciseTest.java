//package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

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
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.putIfAbsent("d", 4);
        map.putAll(new HashMap<String, Integer>() {{
            put("e", 5);
            put("f", 6);
        }});
        Integer test1 = map.get("a");
        assertEquals(test1, map.get("a"));

        assertEquals(7, map.getOrDefault("g", 7).intValue());

        assertEquals(true, map.containsKey("a"));
        assertEquals(false, map.containsValue("h"));
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
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.replace("a", 3);
        map.replace("b", 2, 4);
        map.replaceAll((k, v) -> v * 2);
        assertEquals(6, map.get("a").intValue());

        map.remove("a");
        map.remove("b", 4);

        map.put("a", 3);
        map.compute("a", (k, v) -> v * 2);
        assertEquals(6, map.get("a").intValue());
        map.computeIfAbsent("d", k -> 4);
        assertEquals(4, map.get("d").intValue());
        map.computeIfPresent("d", (k, v) -> v * 2);
        assertEquals(8, map.get("d").intValue());
    }
}
