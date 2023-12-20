package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;
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
        map.put("A", 0);
        map.putIfAbsent("B", 1);
        map.putAll(Map.of("C", 2, "D", 3));

        assertEquals(map.get("A"), Integer.valueOf(0));
        assertEquals(map.firstKey(), "A");
        assertEquals(map.lastKey(), "D");

        assertTrue(map.containsKey("A"));
        assertFalse(map.containsKey("ABC"));

        assertEquals(new HashSet<>(List.of("A", "B", "C", "D")) {
        }, map.keySet());

        int i = 0;
        for (int value: map.values()) { //map.values return a collection view
            assertEquals(value, i++);
        }

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

    }
}
