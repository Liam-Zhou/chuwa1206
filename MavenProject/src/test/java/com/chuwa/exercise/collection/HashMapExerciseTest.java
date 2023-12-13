package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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
        map.put("1", 1);
        map.putIfAbsent("2", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.putAll(map);

        map2.get("1");
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

        assertEquals(5, map.compute("2", (k, v) -> v + 1));
        assertEquals(5, map.get("2"));
        map.computeIfAbsent("1", Integer::parseInt);
        assertEquals(1, map.get("1"));
        map.computeIfPresent("1", (k, v) -> v + 1);
        assertEquals(2, map.get("1"));
    }
}
