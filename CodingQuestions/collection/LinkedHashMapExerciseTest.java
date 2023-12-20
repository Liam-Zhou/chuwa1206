package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class LinkedHashMapExerciseTest {
    /**
     * e.g.
     * HashMap<String, Integer> map = new LinkedHashMap<>();
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
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Baldur's Gate 3", 2023);
        map.putIfAbsent("Baldur's Gate 3", 2017);
        System.out.println(map.get("Baldur's Gate 3"));
        map.putAll(Map.of(
                "Elden Ring", 95,
                "Hades", 92,
                "Fire Emblem", 94
        ));
        assertEquals(95, (int) map.get("Elden Ring"));
        assertEquals(0, (int) map.getOrDefault("Elden Ring 2", 0));

        assertTrue(map.containsKey("Elden Ring"));
        assertTrue(map.containsValue(95));
        assertEquals(Set.of("Baldur's Gate 3", "Elden Ring", "Hades", "Fire Emblem"), map.keySet());
        assertEquals(Set.of(2023, 95, 92, 94), new HashSet<>(map.values()));
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
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Baldur's Gate 3", 2023);
        map.put("Elden Ring", 95);
        map.put("Hades", 92);
        map.put("Fire Emblem", 94);

        map.replace("Baldur's Gate 3", 2023, 2022);
        assertEquals(2022, (int) map.get("Baldur's Gate 3"));

        map.replace("Baldur's Gate 3", 2023);
        assertEquals(2023, (int) map.get("Baldur's Gate 3"));

        map.replaceAll((game, rating) -> rating + 1);
        assertEquals(2024, (int) map.get("Baldur's Gate 3"));

        map.remove("Baldur's Gate 3");
        assertNull(map.get("Baldur's Gate 3"));

        map.remove("Elden Ring", 95);
        assertNull(map.get("Dark Soul"));

        map.compute("Hades", (game, rating) -> rating + 1);
        assertEquals(94, (int) map.get("Hades"));

        map.computeIfAbsent("Elden Ring", game -> 95);
        assertEquals(96, (int) map.get("Elden Ring"));

        map.computeIfPresent("Elden Ring", (game, rating) -> rating + 1);
        assertEquals(97, (int) map.get("Elden Ring"));
    }
}
