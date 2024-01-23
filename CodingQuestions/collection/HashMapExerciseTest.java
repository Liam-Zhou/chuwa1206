package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, Integer> map1 = new HashMap<>();
        map.put("apple",2);
        map.putIfAbsent("banana",3);
        map1.put("melon",1);
        map.putAll(map1);

        System.out.println(map.get("melon"));
        System.out.println(map.getOrDefault("blueberry",0));

        System.out.println(map.containsKey("apple"));
        System.out.println(map.containsValue(3));

        System.out.println(map.keySet());
        System.out.println(map.values());

        System.out.println(map.isEmpty());
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
        Map<String, Integer> map1 = new HashMap<>();
        map.put("apple",2);
        map.putIfAbsent("banana",3);
        map1.put("melon",1);
        map.putAll(map1);

        map.replace("apple",2,4);
        map.replace("melon",2);

        map.remove("melon");
        map.remove("banana",3);

        System.out.println(map);

        map.compute("apple", (key, value) -> value + 5);
        System.out.println(map);
    }
}
