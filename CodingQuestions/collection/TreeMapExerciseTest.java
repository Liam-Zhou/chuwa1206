package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.TreeMap;
import java.util.Map;

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


        map.put("One", 1);
        map.put("Two", 2);
        map.putIfAbsent("Three", 3);

        assertEquals(Integer.valueOf(1), map.get("One"));
        assertEquals("One", map.firstKey());
        assertEquals("Two", map.lastKey());

        assertFalse(map.keySet().isEmpty());
        assertTrue(map.containsValue(1));
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
        map.put("One", 1);
        map.put("Two", 2);


        map.replace("One", 1, 11);
        assertEquals(Integer.valueOf(11), map.get("One"));

        map.remove("Two");
        assertFalse(map.containsKey("Two"));
    }
}
