package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
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
        Map<String, Integer> map=new HashMap<>();
        map.put("One",1);
        map.put("Two",2);

        assertEquals(Integer.valueOf(0),map.getOrDefault("Zero",0));

        assertFalse(map.containsKey("Zero"));
        assertTrue(map.containsValue(2));
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
        Map<String, Integer> map=new HashMap<>();
        map.put("One",1);
        map.put("Two",2);

        map.replace("One", 1, 11);
        assertEquals(Integer.valueOf(11), map.get("One"));

        map.remove("One");
        assertFalse(map.containsKey("One"));

        map.computeIfPresent("Two",(key, value) -> value + 4);

        assertEquals(Integer.valueOf(6),map.get("Two"));
    }
}
