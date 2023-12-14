package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
        map.put("Baldur's Gate 3", 2023);
        map.putIfAbsent("Baldur's Gate 3", 2017);
        System.out.println(map.get("Baldur's Gate 3"));
        map.putAll(Map.of(
                "Elden Ring", 95,
                "Hades", 92,
                "Fire Emblem", 94
        ));
        System.out.println(map);
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.get("Elden Ring"));
        System.out.println(map.containsKey("Elden Ring"));
        System.out.println(map.containsValue(95));
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.isEmpty());
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
        map.put("Baldur's Gate 3", 2023);
        map.putIfAbsent("Baldur's Gate 3", 2017);
        map.putAll(Map.of(
                "Elden Ring", 95,
                "Hades", 92,
                "Fire Emblem", 94
        ));
        map.replace("Elden Ring", 95, 96);
        map.replace("Hades", 93);
        map.remove("Fire Emblem");
        assertEquals(96, (int) map.get("Elden Ring"));
        assertFalse(map.containsKey("Fire Emblem"));
        System.out.println(map);
    }
}
