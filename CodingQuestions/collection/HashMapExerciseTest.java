package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        map.put("Baldur's Gate 3", 2023);
        map.putIfAbsent("Baldur's Gate 3", 2017);
        assertEquals((int) map.get("Baldur's Gate 3"), 2023);

        Map<String, Integer> gameRatings = new HashMap<>();
        gameRatings.put("Elden Ring", 78);
        Map<String, Integer> newGameRatings = Map.of(
                "Elden Ring", 95,
                "Hades", 92,
                "Fire Emblem", 94
        );
        gameRatings.putAll(newGameRatings);
        assertEquals((int) gameRatings.get("Elden Ring"), 95);
        assertEquals((int) gameRatings.get("Hades"), 92);
        assertEquals((int) gameRatings.get("Fire Emblem"), 94);
        assertTrue(gameRatings.containsKey("Elden Ring"));
        assertTrue(gameRatings.containsValue(95));

        assertEquals(Set.of("Elden Ring", "Hades", "Fire Emblem"), gameRatings.keySet());
        assertEquals(Set.of(95, 92, 94), new HashSet<>(gameRatings.values()));
        assertFalse(gameRatings.isEmpty());
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
        Map<String, Integer> gameRatings = new HashMap<>();
        gameRatings.put("Elden Ring", 78);
        gameRatings.put("Hades", 92);
        gameRatings.put("Fire Emblem", 94);

        gameRatings.replace("Elden Ring", 78, 95);
        assertEquals((int) gameRatings.get("Elden Ring"), 95);

        gameRatings.replace("Hades", 92);
        assertEquals((int) gameRatings.get("Hades"), 92);

        gameRatings.replaceAll((game, rating) -> rating + 1);
        assertEquals((int) gameRatings.get("Elden Ring"), 96);
        assertEquals((int) gameRatings.get("Hades"), 93);
        assertEquals((int) gameRatings.get("Fire Emblem"), 95);

        gameRatings.remove("Elden Ring");
        assertFalse(gameRatings.containsKey("Elden Ring"));

        gameRatings.remove("Hades", 93);
        assertFalse(gameRatings.containsKey("Hades"));

        gameRatings.compute("Fire Emblem", (game, rating) -> rating + 1);
        assertEquals((int) gameRatings.get("Fire Emblem"), 96);

        gameRatings.computeIfAbsent("Hades", game -> 93);
        assertEquals((int) gameRatings.get("Hades"), 93);

        gameRatings.computeIfPresent("Hades", (game, rating) -> rating + 1);
        assertEquals((int) gameRatings.get("Hades"), 94);
    }
}
