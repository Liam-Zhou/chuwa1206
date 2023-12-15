package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.*;

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


        map.put("key1", 10);
        assertEquals(Integer.valueOf(10), map.get("key1"));


        map.putIfAbsent("key2", 20);
        assertEquals(Integer.valueOf(20), map.get("key2"));


        assertEquals("key1", map.firstKey());
        assertEquals("key2", map.lastKey());

        assertTrue(map.containsKey("key1"));
        assertTrue(map.containsValue(10));


        assertTrue(map.keySet().contains("key1"));
        assertTrue(map.values().contains(10));


        assertFalse(map.isEmpty());

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
        map.put("key1", 10);
        map.put("key2", 20);

        map.replace("key1", 30);
        assertEquals(Integer.valueOf(30), map.get("key1"));

        map.replace("key2", 20, 40);
        assertEquals(Integer.valueOf(40), map.get("key2"));

        map.remove("key1");
        assertFalse(map.containsKey("key1"));


    }
}
