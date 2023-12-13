package com.chuwa.exercise.collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 * updated kaiyuan
 * 12/13/23
 */
public class AdditionalMapExerciseTest {

    /*
    a thread-safe implementation of the Map interface that allows concurrent reads and updates to the map
     */
    /**
     * e.g.
     * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     */

    @Test
    public void learn_ConcurrentHashMap() {
        // Initialize ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // put(K key, V value)
        map.put("Apple", 10);
        assertEquals((Integer) 10, map.get("Apple"));

        // putIfAbsent(K key, V value)
        map.putIfAbsent("Banana", 20);
        map.putIfAbsent("Apple", 30);
        assertEquals((Integer) 20, map.get("Banana"));
        assertEquals((Integer) 10, map.get("Apple")); // Value for "Apple" remains unchanged since it is already present

        // putAll(Map<? extends K, ? extends V> m)
        Map<String, Integer> anotherMap = new ConcurrentHashMap<>();
        anotherMap.put("Cherry", 15);
        anotherMap.put("Date", 25);
        map.putAll(anotherMap);
        assertEquals((Integer) 15, map.get("Cherry"));
        assertEquals((Integer) 25, map.get("Date"));
    }


    /*
    a special implementation of the Map interface that
    uses reference equality instead of object equality when comparing keys (and values).
    This means two keys k1 and k2 are considered equal in an IdentityHashMap if and only if (k1 == k2)
     */
    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {
        // Initialize IdentityHashMap
        Map<String, Integer> map = new IdentityHashMap<>();

        // Create two different String objects with the same content
        String key1 = new String("key");
        String key2 = new String("key");

        // put(K key, V value)
        map.put(key1, 1);
        assertEquals((Integer) 1, map.get(key1));

        // putIfAbsent(K key, V value)
        map.putIfAbsent(key2, 2);
        assertEquals((Integer) 1, map.get(key1));
        assertEquals((Integer) 2, map.get(key2)); // key2 is a different reference, insertion success

        // Size should be 2 because key1 and key2 are different references
        assertEquals(2, map.size());
    }

    /*
    designed for use with enum type keys
     */
    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
        // Initialize EnumMap with DayOfWeek enum
        Map<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);

        // put(K key, V value)
        enumMap.put(DayOfWeek.MONDAY, 1);
        assertEquals((Integer) 1, enumMap.get(DayOfWeek.MONDAY));

        // putIfAbsent(K key, V value)
        enumMap.putIfAbsent(DayOfWeek.TUESDAY, 2);
        enumMap.putIfAbsent(DayOfWeek.MONDAY, 3); // This will not replace the existing value for MONDAY
        assertEquals((Integer) 2, enumMap.get(DayOfWeek.TUESDAY));
        assertEquals((Integer) 1, enumMap.get(DayOfWeek.MONDAY)); // Value remains unchanged
    }
}
