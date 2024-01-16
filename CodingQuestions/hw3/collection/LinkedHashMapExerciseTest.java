package com.chuwa.exercise.collection;

import org.junit.Test;

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
        Map<String, Integer> map = new LinkedHashMap<>();

        // Putting key-value pairs
        map.put("Apple", 3);
        map.put("Banana", 5);

        // Putting a value only if absent
        map.putIfAbsent("Orange", 2);
        map.putIfAbsent("Apple", 4); // Will not replace Apple

        // Putting all from another map
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("Cherry", 7);
        map.putAll(anotherMap);

        // Getting values
        int appleCount = map.get("Apple");
        int pearCount = map.getOrDefault("Pear", 0);

        // Checking for keys and values
        boolean hasBanana = map.containsKey("Banana");
        boolean hasSix = map.containsValue(6);

        // Retrieving key set and values
        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();
        boolean isEmpty = map.isEmpty();

        // Printing results
        System.out.println("Apple count: " + appleCount);
        System.out.println("Pear count: " + pearCount);
        System.out.println("Has Banana: " + hasBanana);
        System.out.println("Has value 6: " + hasSix);
        System.out.println("Keys: " + keys);
        System.out.println("Values: " + values);
        System.out.println("Is empty: " + isEmpty);
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
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Apple", 3);
        map.put("Banana", 5);

        // Replacing values
        map.replace("Apple", 4); // Replace Apple's value
        map.replace("Banana", 5, 6); // Replace Banana's value if current value is 5

        // Replace all values using a function
        map.replaceAll((key, value) -> value + 1);

        // Removing values
        map.remove("Apple"); // Remove Apple
        map.remove("Banana", 6); // Remove Banana if its value is 6

        // Compute operations
        map.compute("Cherry", (key, value) -> (value == null) ? 1 : value + 1);
        map.computeIfAbsent("Date", key -> 2);
        map.computeIfPresent("Cherry", (key, value) -> value * 2);

        // Printing the map
        map.forEach((key, value) -> System.out.println(key + ": " + value));

    }
}
