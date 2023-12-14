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
        map.put("One", 1);
        map.put("Two", 2);
        map.putIfAbsent("Three", 3);

        assertEquals(Integer.valueOf(1), map.get("One"));
        assertEquals(Integer.valueOf(4), map.getOrDefault("Four", 4));

        assertTrue(map.containsKey("Two"));
        assertFalse(map.containsValue(4));
        assertTrue(map.containsValue(1));

        assertFalse(map.isEmpty());

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
        map.put("One", 1);
        map.putIfAbsent("Two",2);


        map.replace("One", 11);
        assertEquals(Integer.valueOf(11), map.get("One"));



        map.computeIfPresent("Two", (key,value) -> value+2);
        assertEquals(Integer.valueOf(4), map.get("Two"));

        map.remove("One");
        assertFalse(map.containsKey("One"));
    }
}
