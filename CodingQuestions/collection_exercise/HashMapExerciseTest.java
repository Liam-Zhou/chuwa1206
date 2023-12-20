package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.*;
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
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("A", 1);
        map.putIfAbsent("A",2);
        map.putAll(Map.of("B",2, "C", 3));
        assertEquals(Map.of("A", 1, "B",2, "C", 3), map);

        assertEquals(map.get("A"), Integer.valueOf(1));
        assertNull(map.get("D"));
        assertEquals(map.getOrDefault("D", 0), Integer.valueOf(0));

        assertTrue(map.containsKey("C"));
        assertFalse(map.containsValue(100));

        assertEquals(new HashSet<>(List.of("A", "B", "C")) {
        }, map.keySet());

        int i = 1;
        for (int value: map.values()) { //map.values return a collection view
            assertEquals(value, i++);
        }

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
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("B", 0);
        map.put("C", 0);
        // if key is matching a specific value then replace with new value
        assertFalse(map.replace("A",1,1));
        assertFalse(map.replace("D",1,1));
        assertTrue(map.replace("A",0,1));

        // if key exists, then replace
        map.replace("D",1);
        assertNull(map.get("D"));
        map.replace("C", 1);
        assertEquals(map.get("C"), Integer.valueOf(1));

        map.replaceAll((key, oldValue) -> oldValue+1);
        assertEquals(map.get("C"), Integer.valueOf(2));

        map.remove("C");
        assertNull(map.get("C"));

        //remove if key and value are matched
        map.remove("A",0); // not matched
        assertNotNull(map.get("A"));
        map.remove("A",2); // matched
        assertNull(map.get("A"));

        // Compute: This method is used to automatically update a value for given key in HashMap.
        map.compute("D", (key, val) -> (val == null)? 1: val+5);
        assertEquals(map.get("D"), Integer.valueOf(1)); // If absent, the key, val will be added to the map

        map.computeIfPresent("D", (key, val) -> val+5);
        assertEquals(map.get("D"), Integer.valueOf(6));

        map.computeIfAbsent("E", (val) -> 100);
        assertEquals(map.get("E"), Integer.valueOf(100));







    }
}
