package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

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
        map.put("a", 1);
        map.put("c", 3);
        map.putIfAbsent("b", 2);
        map.putAll(new TreeMap<String, Integer>() {{
            put("d", 4);
            put("e", 5);
        }});
        assertEquals(5, map.size());
        assertEquals(1, map.get("a").intValue());
        assertEquals("a", map.firstKey());
        assertEquals("e", map.lastKey());
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
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.putAll(new TreeMap<String, Integer>() {{
            put("a", 1);
            put("b", 2);
            put("c", 3);
        }});
        map.replace("a", 1, 4);
        assertEquals(4, map.get("a").intValue());
        map.replace("b", 5);
        assertEquals(5, map.get("b").intValue());
        map.remove("c");
        assertEquals(2, map.size());
    }
}
