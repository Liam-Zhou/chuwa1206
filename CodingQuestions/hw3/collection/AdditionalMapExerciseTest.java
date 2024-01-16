package com.chuwa.exercise.collection;

import org.junit.Test;

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
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Demonstrating the 'put' method
        map.put("Key1", 1);
        map.put("Key2", 2);

        // Demonstrating the 'putIfAbsent' method
        map.putIfAbsent("Key2", 22); // This will not change the value of "Key2" as it's already present
        map.putIfAbsent("Key3", 3);  // This will add "Key3" as it's not present

        // Demonstrating the 'putAll' method
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("Key4", 4);
        anotherMap.put("Key5", 5);
        map.putAll(anotherMap);

        // Printing the map to verify the operations
        map.forEach((key, value) -> System.out.println(key + ": " + value));

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
        IdentityHashMap<DayOfWeek, Integer> map = new IdentityHashMap<>();

        // Demonstrating the 'put' method
        map.put(DayOfWeek.MONDAY, 1);
        map.put(DayOfWeek.TUESDAY, 2);

        // Demonstrating the 'putIfAbsent' method
        map.putIfAbsent(DayOfWeek.TUESDAY, 22); // This will not change the value for TUESDAY
        map.putIfAbsent(DayOfWeek.WEDNESDAY, 3); // This will add WEDNESDAY as it's not present

        // Printing the map to verify the operations
        map.forEach((key, value) -> System.out.println(key + ": " + value));

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
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);

        // Demonstrating the 'put' method
        enumMap.put(DayOfWeek.MONDAY, 1);
        enumMap.put(DayOfWeek.TUESDAY, 2);

        // Demonstrating the 'putIfAbsent' method
        enumMap.putIfAbsent(DayOfWeek.TUESDAY, 22); // This will not change the value for TUESDAY
        enumMap.putIfAbsent(DayOfWeek.WEDNESDAY, 3); // This will add WEDNESDAY as it's not present

        // Printing the map to verify the operations
        enumMap.forEach((key, value) -> System.out.println(key + ": " + value));

    }
}
