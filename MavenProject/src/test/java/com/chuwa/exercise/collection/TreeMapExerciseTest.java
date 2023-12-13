package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;
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
        map.put("1", 1);
        map.putIfAbsent("2", 2);

        TreeMap<String, Integer> map2 = new TreeMap<>();
        map2.putAll(map);

        map2.get("1");
        assertEquals("1", map.firstKey());
        assertEquals("2", map.lastKey());
        map2.getOrDefault("3", 0);

        assertFalse(map2.containsKey("3"));
        assertFalse(map2.containsValue(3));

        assertArrayEquals(new String[]{"1", "2"}, map2.keySet().toArray());
        assertArrayEquals(new Integer[]{1, 2}, map2.values().toArray());
        assertFalse(map2.isEmpty());
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
        map.put("1", 1);
        map.put("2", 2);
        map.replace("2", 2, 3);
        assertEquals(3, map.get("2"));
        map.replace("1", 2);
        map.replaceAll((key, value) -> value + 1);
        assertArrayEquals(new Integer[]{3, 4}, map.values().toArray());

        map.remove("1");
        map.remove("2", 2);
        assertTrue(map.containsKey("2"));
    }
}
