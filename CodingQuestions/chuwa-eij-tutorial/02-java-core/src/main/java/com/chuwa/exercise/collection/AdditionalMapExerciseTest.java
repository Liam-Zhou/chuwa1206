package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class AdditionalMapExerciseTest {

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
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("Baldur's Gate 3", 2023);
        map.putIfAbsent("Baldur's Gate 3", 2017);
        assertEquals((int) map.get("Baldur's Gate 3"), 2023);

        Map<String, Integer> gameRatings = new ConcurrentHashMap<>();
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
    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {
        Map<String, Integer> map = new IdentityHashMap<>();
        String myString1 = new String("myString1");
        map.put("myString1", 1);
        map.put(myString1, 2);
        assertEquals((int) map.get("myString1"), 1);
        map.forEach((game, rating) -> System.out.println(game + ": " + rating));
    }



    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }
    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
        Map<Day, String> map = new EnumMap<>(Day.class);

        map.put(Day.MONDAY, "Start of workday");
        map.put(Day.FRIDAY, "End of workday");
        map.put(Day.SATURDAY, "Weekend");
        map.put(Day.SUNDAY, "Weekend");

        assertEquals(map.get(Day.MONDAY), "Start of workday");
        assertEquals(map.get(Day.SATURDAY), "Weekend");
        assertEquals(map.get(Day.TUESDAY), null);
    }
}
